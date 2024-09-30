​    常见消息队列kafka rocketmq pulsar对比



## 部署架构

kafka：zookeeper集群、broker集群

RocketMq：NameServer集群、broker集群

Pulsar：bookeeper集群（日志存储系统）、broker集群 ，典型地计算与存储分离的架构。

## 元数据存储

kafka：2.8版本以前是在zookeeper上存储 2.8版本之后，抛弃zookeeper，采用类似RAFT协议，主要考虑到当集群节点比较多，topic数量比较多时，zookeeper就会成为系统瓶颈。

```java
/brokers
	/broker/ids/   所有的broker节点，每个broker的配置文件中都需要指定一个数字类型的id
	/broker/topics/  所有的topic注册信息；
	/brokers/topics/[topic_name]/partitions/ 某个topic的partitions所有分配信息；

/controller
	/controller_epoch Controller的选举次数（默认从1开始）

/consumers
	/consumers/[group_id]/ids/ Consumer订阅信息，每个consumer都有一个唯一的ID用来标记消费者信息；
	/consumers/[group_id]/owners/[topic_name]/[partition_id]  consumer group对应的各个topic及partition的消费者线程。
	/consumers/[group_id]/offsets/[topic_name]/[partition_id] consumer group对应的各个topic及partition的消费偏移量。

/admin
	/admin/reassign_partitions  partition重分配信息；
	/admin/preferred_replica_election 最优replica选举信息；
	/admin/delete_topics  近期删除的topic；
/isr_change_notification/  ISR变更通知信息；
                 
```



Rocketmq：存储在nameserver上



## 网络层

kafka：基于Java NIO开发的kafka network 客户端

rocketMq：基于Netty异步网络I/O通信框架开发，NettyRemotingClient和NettyRemotingServer

pulsar：



## 存储层

<img src="mq_log_store.jpg" alt="mq_log_store" style="zoom:30%;" />

索引文件：Index文件，稀疏索引

日志文件：存储每条日志

kafka：每个topic，每个分区，在一个日志文件中。

rocketmq：多个topic的分区记录可以存储在一个日志文件中

pulsar：每个topic每个分区的数据单独存储在bookeeper中



## 消息功能特性

延迟消息：rocketmq支持不同级别的延迟消息，具体的实现策略是会有一个单独的topic ___xxx_topic 记录所有延迟topic的消息，这条消息会多一个属性，就是延迟的消息级别。然后会有一个定时任务消费这个topic去扫描，是否满足延迟条件，如果满足，则将这条消息发送到真正的topic上。

事务消息：



共通之处：

## 高可用设计

副本管理

kafka ISR的概念 每个分区都有Leader，N个副本，副本是异步拉取消息进行数据同步的。



## 高性能设计

PageCache：是操作系统的文件缓存机制。

Zero-Copy

顺序写磁盘

