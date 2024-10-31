# Flink原理



#####  与其他Hadoop生态之间的依赖关系

 Hbase作为外部存储（列式存储）应对大数据存储，背后是Htable，底层是HDFS数据。

 Redis作为外部缓存，处理一些高频访问的场景，比如黑名单、白名单等



##  运行模式机制
* MiniCluster模式 也就是local模式

* standalone 模式

* on yarn 模式

  

## 计算引擎如何工作？ 
JAR包分发

Job Manager（JobGraph、容灾等功能） 

Task Manager（具体的执行节点）

后端state（内存、rocksDB或HDFS）

**资源是如何分配的**： TaskSlot、相互之间通信（actor系统） 、内存管理（堆内、堆外内存）

## API都有哪些
*  Window:滑动窗口、翻转窗口
* 算子：map、flatmap、keyby、 groupby、distinct、count等

## Flink watermark机制
watermark是为了处理乱序的事件时间，而提出的一种概念，watermark标记了当前窗口已经处理到的最低事件时间，小于watermark的事件，不会被处理，大于watermark的事件，则会被处理。

窗口（用户侧接口，包括滑动窗口、翻转窗口等）、checkpoint（分布式快照） 、State（用于存储算子执行过程中的数据）、watermark机制

##  内存管理机制

JVM内存、堆外内存

##  资源分配管理机制

并行度、SLOT、线程之间的关系

## window机制



##   Failover 机制



### Movitation
  当一个任务失败时，Flink将从上一次完成的checkpoint中重置整个execution graph，然后整个任务会重启。这种代价开销挺大的，特别对于整个JobGraph并没有keyby类似的操作时候

### 常见错误
* JobManager is no longer the leader
*   xxx



#### 经典的一些问题

##### 1. 性能出现瓶颈怎么办？如何进行调优？

 **问题定位**： 否有反压、数据是否有倾斜 

 **解决方案**：资源调整（并行度、作业参数调优、Java内存调优）、用户代码调优（数据打散、预聚合等）

##### 2. Exactly once 是如何保证的？

   checkpoint 、二阶段提交协议、下游保证分布式事务

##### 3. 高性能技术有哪些？

  //



Flink SQL

Flink CDC异构数据源同步



  [DataFlow编程模型](https://www.jianshu.com/p/0faa1c1caa47) <br>
  [Flink Spark对比](https://www.infoq.cn/article/spark-vs-flink) <br>
  [Flink Storm对比](https://tech.meituan.com/2017/11/17/flink-benchmark.html) <br>
  [如何使用Spark Streaming + Kafka如何实现精确一次语义?](https://www.zhihu.com/question/334249637/answer/744493120) <br>

### Flink Example 

  [Flink Training](https://training.ververica.com/) <br> 
  [Flink如何让每一条数据进来后延迟一段时间再被处理?](https://www.zhihu.com/question/332577514/answer/840181621)  <br>

### Flink 原理解析 

  [Flink Runtime核心机制解析](https://www.infoq.cn/article/RWTM9o0SHHV3Xr8o8giT)   <br>
  [Flink Window 机制解析](http://wuchong.me/blog/2016/05/25/flink-internals-window-mechanism/#comments) <br>
  [Flink Watermark 解析](https://blog.csdn.net/lmalds/article/details/52704170) <br>
  [Flink 反压解析 ](http://wuchong.me/blog/2016/04/26/flink-internals-how-to-handle-backpressure/) <br>
  [Flink 内存管理解析](http://wuchong.me/blog/2016/04/29/flink-internals-memory-manage/) <br>
  [Flink 分布式快照解析](http://xargin.com/distributed-snapshot-in-stream-sys/) <br>
  [Flink checkpoint与savepoint的区别](https://www.whitewood.me/2018/09/06/Flink-Checkpoint-Savepoint-%E5%B7%AE%E5%BC%82/) <br>
  [Flink failover机制解析--待翻译](https://cwiki.apache.org/confluence/display/FLINK/FLIP-1+%3A+Fine+Grained+Recovery+from+Task+Failures) <br>
  [\[原创\]Flink TTL state解析](https://github.com/yyb345/index/blob/master/flink/ttl_state.md) <br>


  [Flink-分布式快照的设计](http://chenyuzhao.me/2018/01/29/Flink-%E5%88%86%E5%B8%83%E5%BC%8F%E5%BF%AB%E7%85%A7%E7%9A%84%E8%AE%BE%E8%AE%A1-%E6%B5%81%E7%A8%8B/) <br>

  [Flink  Kafka 0.11 exactly once](https://www.cnblogs.com/huxi2b/p/8459342.html) <br>
  [Flink Exactly-Once 解析](http://www.whitewood.me/2018/10/16/Flink-Exactly-Once-%E6%8A%95%E9%80%92%E5%AE%9E%E7%8E%B0%E6%B5%85%E6%9E%90/) <br>
  [Flink State 使用文档](https://ci.apache.org/projects/flink/flink-docs-master/dev/stream/state/state.html) <br>
   [Memory Management and Configuration Reloaded - Google 文档](https://docs.google.com/document/d/1o4KvyyXsQMGUastfPin3ZWeUXWsJgoL7piqp1fFYJvA/edit#heading=h.ie6fcly7mrci) <br>
   [Memory Management (Batch API) ](https://cwiki.apache.org/confluence/pages/viewpage.action?pageId=53741525) <br>
  [FLIP-50: Spill-able Heap Keyed State Backend](https://cwiki.apache.org/confluence/display/FLINK/FLIP-50%3A+Spill-able+Heap+Keyed+State+Backend) <br>
