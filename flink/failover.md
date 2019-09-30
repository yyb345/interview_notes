# Flink failover机制详解

## Movitation
  当一个任务失败时，Flink将从上一次完成的checkpoint中重置整个execution graph，然后整个任务会重启。这种代价开销挺大的，特别对于整个JobGraph并没有keyby类似的操作时候
 
## 常见错误
* JobManager is no longer the leader
*   xxx



##  全部重启
##  最小子集重启
