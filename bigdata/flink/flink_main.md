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
