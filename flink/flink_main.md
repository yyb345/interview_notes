# Flink 整体流程



##  运行模式机制
*  MiniCluster模式 也就是local模式
*  standalone 模式
*  on yarn 模式

## 计算引擎如何工作？ 
JAR包分发，JobManager、TaskManager

## API都有哪些
*  Window:滑动窗口、翻转窗口
* 算子：keyby、map、reduce

## Flink watermark机制
watermark是为了处理乱序的事件时间，而提出的一种概念，watermark标记了当前窗口已经处理到的最低事件时间，小于watermark的事件，不会被处理，大于watermark的事件，则会被处理。

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

###  全部重启
###  最小子集重启

