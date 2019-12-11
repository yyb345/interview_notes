# Flink Failover机制详解




## Movitation

  作为流行的实时流计算框架，高性能、高可用是两个重要的因素，本文将全面分析Flink的高可用设计之道。


## Flink 编程模型

### 流式处理框架

### 一个常见的例子

### Flink 如何生成JobGraph？



## 常见的任务失败场景
* JobManager 失败
*  TaskManger 失败
 

## 如何恢复？

### 恢复能保证exactly once么？

### 分布式快照

###  对比SPARK、MapReduce恢复机制？




## 恢复改进之处?
  当一个任务失败时，Flink将从上一次完成的checkpoint中重置整个execution graph，然后整个任务会重启。这种代价开销挺大的，特别对于整个JobGraph并没有keyby类似的操作时候

最核心的是仅仅重启失败task相联通的上游流水线任务，这是最基本的fail-over的策略。我们可以通过以下两个步骤来提升：

###  版本一：整个相关的连通组件重启
假设所有的算子通过流水线连接，
###  版本二：中间结果保存
为了进一步重启减少任务的数量，我们可以用stream之间交换的数据类型。在运行时框架，他们被称为“中间结果类型”，

*  caching 中间结果   在checkpoint中缓存数据流中所有的元素，如果可以保存在磁盘上
*  memory-only caching
*  

###  全部重启

###  最小子集重启
