redis基本原理

1. redis是什么？

     是一个KV缓存中间件，实现高性能KV读取。

2. redis支持哪些数据类型？

3. redis应用场景？

      1. 缓存
      2. redis分布式锁的实现方式（本地写代码实现一个基于redis的分布式锁，基于多线程）

4. redis线程模型？

        网络IO单线程、NIO、内存

5. redis的稳定性是如何保证的？

      AOF（Append Of File） 写日志

      ADB快照 数据



缓存的通用问题

   缓存穿透：布隆过滤器、KV value为null值

   缓存雪崩：



redis的应用场景优化

1. redis常见问题是如何解决的，比如热点问题、大key、大量key读

         热点问题：

      ​    大key：

         大量key：

2. redis的原理，如何实现高性能

3. 不止redis，与其他缓存相比，有什么优缺点？