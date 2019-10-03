# Flink 整体流程



##  运行模式机制
*  MiniCluster模式 也就是local模式
*  standalone 模式
*  on yarn 模式

## 计算引擎如何工作？ 
JAR包分发，JobManager、TaskManager

## API都有哪些
*  window
* 

##  内存管理机制

##  资源分配管理机制

## window机制
##   Failover 机制
### Movitation
  当一个任务失败时，Flink将从上一次完成的checkpoint中重置整个execution graph，然后整个任务会重启。这种代价开销挺大的，特别对于整个JobGraph并没有keyby类似的操作时候
 
### 常见错误
* JobManager is no longer the leader
*   xxx

###  全部重启
###  最小子集重启

