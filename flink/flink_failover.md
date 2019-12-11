# Flink Failover机制详解




##  前言

  作为流行的实时流计算框架，高性能、高可用是两个重要的因素，本文将全面分析Flink的高可用设计之道。


## Flink 编程模型（API层）

### 流式处理框架

### 一个常见的例子
``` java 
DataStream<Tuple2<String, Integer>> counts =
			// split up the lines in pairs (2-tuples) containing: (word,1)
			text.flatMap(new Tokenizer())
			// group by the tuple field "0" and sum up tuple field "1"
			.keyBy(0).sum(1);
```

### Flink 如何生成JobGraph？
 这部分需要着重理解下JobGraph，因为后续的失败场景恢复是基于此的。

什么是执行计划？
什么是jobgraph? 为什么需要jobgraph? 它是一种数据流描述编程方法
 
 顶点、边 分别代表什么
 
 这些都是在api层定义的东西
 
 为什么会有 StreamGraph JobGraph等数据结构？

四层转化流程？讲清楚这个东西


### JobGraph的理解


## 常见的任务失败场景
由于flink计算引擎中存在两种角色，任何一个角色失败都会导致整个计算流失败，下面列了一些这两种角色经常遇到的问题

* JobManager 失败
*  TaskManger 失败
 

## 如何恢复？
对于存储系统来说，是数据恢复，对于计算引擎来说，是数据处理流恢复以及数据结果的恢复。

### 恢复能保证exactly once么？

### 分布式快照

有向无环图数据的动态保存以及恢复

state 相当于内置了KV存储

###  对比Spark、MapReduce恢复机制？




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

##  总结


