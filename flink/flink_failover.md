# Flink failover机制详解

翻译原文来自 FLIP--1： 任务失败后，细粒度的恢复策略
## Movitation
  当一个任务失败时，Flink将从上一次完成的checkpoint中重置整个execution graph，然后整个任务会重启。这种代价开销挺大的，特别对于整个JobGraph并没有keyby类似的操作时候
 
## 常见错误
* JobManager is no longer the leader
*   xxx


## 提议改进
最核心的是仅仅重启失败task相联通的上游流水线任务，这是最基本的fail-over的策略。我们可以通过以下两个步骤来提升：

###  版本一：整个相关的连通组件重启
假设所有的算子通过流水线连接，
###  版本二：中间结果保存
为了进一步重启减少任务的数量，我们可以用stream之间交换的数据类型。在运行时框架，他们被称为“中间结果类型”，

*  caching 中间结果   在checkpoint中缓存数据流中所有的元素，如果可以保存在磁盘上
*  memory-only caching
*  
##  全部重启
##  最小子集重启
