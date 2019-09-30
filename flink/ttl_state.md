
# Flink State TTL解析
## State与TTL State简介
什么是State？ State分为哪几种？
  流式计算中
为什么会有state？
保存状态（包括计算状态）
举例子说明：

分为哪几种state？ValueState，ListState，MapState，ReducingState，AggregatingState，FoldingState？都是keybyState，也就是keyStream

* ValueState
* ListState
* MapState
* ReducingState
* AggregatingState
* FoldingState

### StateBackend有哪些？
* 堆
* RocksDb 

### 如何手动实现state定期删除？
Flink中用户state在某种场景下会持续增长，需要删除过期的state，而用户需要采用Flink的timerService手动去实现state的删除，如下

```java
public class StateTimerFunction extends KeyedProcessFunction<String,byte[],String> {

	private static final Logger logger = LoggerFactory.getLogger(StateTimerFunction.class);

	private ValueState<byte[]> sendCacheStorage;
	private static final Long TTL_MINUTE=5*60*1000L;
	@Override
	public void open(Configuration parameters) throws Exception {
		sendCacheStorage = getRuntimeContext().getState(new ValueStateDescriptor<byte[]>("sendCacheStorage", byte[].class));
	}

	@Override
	public void processElement(byte[] bytes, Context context, Collector<String> collector) throws Exception {

		try {
			//注册触发时间
			context.timerService().registerProcessingTimeTimer(System.currentTimeMillis() + TTL_MINUTE);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void onTimer(long timestamp, OnTimerContext ctx, Collector<String> out) throws Exception {
	    // 定时会触发该操作
		sendCacheStorage.clear();
	}

}
```

## TTL State源码分析
### 设计思想
其实现思想也比较朴素，首先为每个Value加上时间戳，其次采用[惰性删除](https://baike.baidu.com/item/%E6%83%B0%E6%80%A7%E5%88%A0%E9%99%A4)的策略。caffine cache，rocksDB，redis过期删除都采取了这种策略。简单来讲，就是在下一次访问数据的时候，会判断数据是否过期，若过期，则删除，否则数据依然存在 

```java
    public class TtlValue<T> implements Serializable {
		// 为value加上时间戳
		private static final long serialVersionUID = 5221129704201125020L;
	
		@Nullable
		private final T userValue;
		private final long lastAccessTimestamp;
	
	
		public TtlValue(@Nullable T userValue, long lastAccessTimestamp) {
			this.userValue = userValue;
			this.lastAccessTimestamp = lastAccessTimestamp;
		}
	}

```
本文将从以下几个方面来介绍    

![avatar](ttl_state_process.PNG)

代码结构
重点解析下每种惰性实现

### TTL清除策略
* 全量SNAPSHOT清理：若开启checkpoint，定期保存的快照会删除过期数据，但是stateBackend并不会删除，只有等下一次作业重启，Flink会load保存的快照，而保存的快照并没有过期数据。
* 增量清理：适用于堆内存的stateBackend

### TTL ListValueState 实现
* update实现
* get实现
* 迭代器实现 也比较简单
  
   ```java
  	private class IteratorWithCleanup implements Iterator<T> {
		private final Iterator<TtlValue<T>> originalIterator;
		private boolean anyUnexpired = false;
		private boolean uncleared = true;
		private T nextUnexpired = null;

		private IteratorWithCleanup(Iterator<TtlValue<T>> ttlIterator) {
			this.originalIterator = ttlIterator;
		}

		@Override
		public boolean hasNext() {
		// 寻找下一个未过期的
			findNextUnexpired();
			cleanupIfEmpty();
			return nextUnexpired != null;
		}

		private void cleanupIfEmpty() {
			boolean endOfIter = !originalIterator.hasNext() && nextUnexpired == null;
			if (uncleared && !anyUnexpired && endOfIter) {
				original.clear();
				uncleared = false;
			}
		}

		@Override
		public T next() {
			if (hasNext()) {
				T result = nextUnexpired;
				nextUnexpired = null;
				return result;
			}
			throw new NoSuchElementException();
		}

		private void findNextUnexpired() {
			while (nextUnexpired == null && originalIterator.hasNext()) {
				TtlValue<T> ttlValue = originalIterator.next();
				if (ttlValue == null) {
					break;
				}
				boolean unexpired = !expired(ttlValue);
				if (unexpired) {
					anyUnexpired = true;
				}
				if (unexpired || returnExpired) {
					nextUnexpired = ttlValue.getUserValue();
				}
			}
		}
	}
   ```
    

### TTL MapState 实现
* update实现
* get实现
* 迭代器实现

## TTL State 现有的不足之处

* 不支持一条数据过期后，有相应的触发操作，也即类似拦截器的作用
* 当一条数据不被访问时，该数据可能不会被删除 

## TTL State如何使用？
 TTL各个配置含义：
StateTtlConfig 配置详解

```java
StateTtlConfig ttlConfig = StateTtlConfig
    .newBuilder(Time.seconds(1))
    .setUpdateType(StateTtlConfig.UpdateType.OnCreateAndWrite)
    .setStateVisibility(StateTtlConfig.StateVisibility.NeverReturnExpired)
    .build();
    
ValueStateDescriptor<String> stateDescriptor = new ValueStateDescriptor<>("text state", String.class);
stateDescriptor.enableTimeToLive(ttlConfig);
```


