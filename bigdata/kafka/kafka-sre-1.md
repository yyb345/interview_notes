# 集群突发流量部分kafka broker不可用排查

## 问题
kafka 集群偶尔会有突发性写大量的数据情况，也就是有个瞬时流量写高峰。这个时候会出现某一个broker服务不可用的情况，客户端报no leader partition，服务端报 org.apache.zookeeper.ClientCnxn: Client session timed out错误
## 排查过程
从kafka监控平台上观察到某个broker骤降，于是查看对应时间点的server.log日志,发现是
org.apache.zookeeper.ClientCnxn: Client session timed out,然后导致该broker失去连接，进而重新触发controller选举

``` java
2018-11-06 23:07:05,016 INFO org.apache.zookeeper.ClientCnxn: Client session timed out, have not heard from server in 6712ms for sessionid 0x15b8f32a075e8e7, closing socket connection and attempting reconnect
2018-11-06 23:07:05,357 INFO org.I0Itec.zkclient.ZkClient: zookeeper state changed (Disconnected)
2018-11-06 23:07:06,598 INFO org.apache.zookeeper.ClientCnxn: Opening socket connection to server xxx:2181. Will not attempt to authenticate using SASL (unknown error)
2018-11-06 23:07:06,599 INFO org.apache.zookeeper.ClientCnxn: Socket connection established, initiating session, client: /xxx:65427, server: xxx:2181
2018-11-06 23:07:06,851 INFO org.I0Itec.zkclient.ZkClient: zookeeper state changed (Expired)
2018-11-06 23:07:06,851 INFO org.apache.zookeeper.ClientCnxn: Unable to reconnect to ZooKeeper service, session 0x15b8f32a075e8e7 has expired, closing socket connection
2018-11-06 23:07:06,851 INFO org.apache.zookeeper.ZooKeeper: Initiating client connection, connectString=xxxx:2181,xxx:2181,x.com:2181/violet-light-v2 sesxxsionTimeout=6000 watcher=org.I0Itec.zkclient.ZkClient@602e0143
2018-11-06 23:07:06,865 INFO kafka.controller.KafkaController$SessionExpirationListener: [SessionExpirationListener on 146], ZK expired; shut down all controller components and try to re-elect
2018-11-06 23:07:06,866 INFO org.apache.zookeeper.ClientCnxn: EventThread shut down
2018-11-06 23:07:07,334 INFO org.apache.zookeeper.ClientCnxn: Opening socket connection to server xxx:2181. Will not attempt to authenticate using SASL (unknown error)
2018-11-06 23:07:07,465 INFO org.apache.zookeeper.ClientCnxn: Socket connection established, initiating session, client: /xxxx:64206, server: xxxxx:2181
2018-11-06 23:07:07,469 INFO org.apache.zookeeper.ClientCnxn: Session establishment complete on server xxxx:2181, sessionid = 0x15b8f32a075ec38, negotiated timeout = 6000
2018-11-06 23:07:07,469 INFO org.I0Itec.zkclient.ZkClient: zookeeper state changed (SyncConnected)
2018-11-06 23:07:07,472 INFO kafka.controller.TopicDeletionManager$DeleteTopicsThread: [delete-topics-thread-146], Shutting down
2018-11-06 23:07:07,622 INFO kafka.controller.TopicDeletionManager$DeleteTopicsThread: [delete-topics-thread-146], Shutdown completed
2018-11-06 23:07:07,622 INFO kafka.controller.TopicDeletionManager$DeleteTopicsThread: [delete-topics-thread-146], Stopped
2018-11-06 23:07:07,798 INFO kafka.controller.PartitionStateMachine: [Partition state machine on Controller 146]: Stopped partition state machine
2018-11-06 23:07:07,814 INFO kafka.controller.ReplicaStateMachine: [Replica state machine on controller 146]: Stopped replica state machine
2018-11-06 23:07:07,817 INFO kafka.controller.RequestSendThread: [Controller-146-to-broker-146-send-thread], Shutting down
2018-11-06 23:07:07,817 INFO kafka.controller.RequestSendThread: [Controller-146-to-broker-146-send-thread], Stopped
Shutdown completed
2018-11-06 23:07:07,823 INFO kafka.controller.KafkaController: [Controller 146]: Broker 146 resigned as the controller
2018-11-06 23:07:07,836 INFO kafka.server.KafkaHealthcheck$SessionExpireListener: re-registering broker info in ZK for broker 146
2018-11-06 23:07:07,849 INFO kafka.utils.ZKCheckedEphemeral: Creating /brokers/ids/146 (is it secure? false)
2018-11-06 23:07:07,850 INFO kafka.utils.ZKCheckedEphemeral: Result of znode creation is: OK
2018-11-06 23:07:07,851 INFO kafka.utils.ZkUtils: Registered broker 146 at path /brokers/ids/146 with addresses: EndPoint(xxxxx,ListenerName(PLAINTEXT),PLAINTEXT)
2018-11-06 23:07:07,852 INFO kafka.server.KafkaHealthcheck$SessionExpireListener: done re-registering broker
2018-11-06 23:07:07,853 INFO kafka.server.KafkaHealthcheck$SessionExpireListener: Subscribing to /brokers/topics path to watch for new topics

```

再观察controller的变化，确实变了

``` javascript
{"version":1,"brokerid":147,"timestamp":"1541516826025"}
cZxid = 0x102da1b54
ctime = Tue Nov 06 23:07:06 CST 2018
mZxid = 0x102da1b54
mtime = Tue Nov 06 23:07:06 CST 2018
pZxid = 0x102da1b54
cversion = 0
dataVersion = 0
aclVersion = 0
ephemeralOwner = 0x35b8f32a0656879
dataLength = 56
numChildren = 0

```

4.从clouder manager官网上得到确认
Garbage Collection（https://www.cloudera.com/documentation/kafka/latest/topics/kafka_performance.html#concept_f3v_hzk_br）跟我们的场景很类似,长时间gc会影响zk session
5. 查看gc log FULL GC情况:每次full gc时间超过6秒， 而我们的kafka 配置zookeeper.session.timeout.ms是6秒
6. 原因分析

**所以解决方案：是增大zookeeper.session.timeout.ms 6秒改为10秒**
