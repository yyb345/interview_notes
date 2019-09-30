# Kafka 端到端源码解析



## Topic创建

### Topic分区Leader选举

*  若unclean.leader.election.enable为true，再去replica中去找存活的broker。而ISR中的broker存在是这样：只有当follower从leader拉取数据跟得上leader的数据速度时，才会在ISR中，否则，被剔除掉ISR列表中。
*  若unclean.leader.election.enable为false，抛出异常

1. 那么Leader的选举为什么要这样设计呢？为什么会有unclean.leader.election.enable这个参数呢？
从根源上看，与kafka的副本复制机制有关系，它并不像RAFT那样具有强一致性，它是副本批量复制，而且follower的消息确认的选择权是在用户侧producer上的，用户可以根据ack去设置消息被复制的级别。

那么数据一致性是如何保证的呢，如何知道副本的状态是可靠的？ISR就保存了kafka认为可靠的副本，它们具备这样的条件：1 . 落后leader的消息条数在一定阈值内 2.或者落后在一定时间内；
但是，follower的复制状态谁又能保证一定能跟得上leader呢？这样，就存在着一种可能性，有可能ISR中只有leader,其他的副本都跟不上leader; 因此，这个时候，patition到底可用不可用？这就是一个权衡了，若只从ISR中获取leader，保证了数据的可靠性，但partition就不可用了，若从replica中获取，则可用性增强，但是数据可能存在丢失情况。

因此unclean.leader.election.enable这个参数设计为true，则保证了可用性，也就是CAP中的A P;设置为false，则保证了数据一致性，也就是CAP中的CP

## kafka producer解析

### 1. 发送流程
* 第一步： 刷新元数据
* 第二步： 序列化、选择分区、注册拦截器回调函数
* 第三步： 往RecordAccmulator发送数据
* 第四步：判断batch是否满了，满了的话唤醒send后台线程 <br>
  有可能的异常：API版本不匹配；Buffer耗尽等

### 2. 分区选择策略？
*  若该消息内无指定分区，则使用消息中指定的key哈希生成的分区
*  若key为null，则按照轮询的方式生成分区
*  最后一种，若仍然不满足需求，用户还可以自己指定partition分区策略类，每条消息都按照这个策略进行  <br>
    因此，分区策略可以有四个级别：用户自定义分区策略类、key哈希、轮询、任一消息选择任一分区，总的来说给用户很大的自由度。


### 3. 拦截器有什么作用？
在每次消息处理前增加一个回调函数，一般用来记录一些统计信息，为每条消息增加其他字段等等。

### 4. 关键数据结构
RecordAccmulator的内部是如何运作的？

《TopicPartition，Batch队列》这是重要的数据结构

有一个缓冲池bufferPool，每次开始是已经有batch在发，如果不存在则开辟batchSize大小的空间；然后往Batch队列的append数据，并且使得offset+1,然后会生成一个FutureRecordMetadata，用来表示batch是否满

## kafka 存储层


