## 1.JVM学习

### JAVA语言基础

 [Java 泛型解析](https://www.zhihu.com/question/20400700)  <br>

### JAVA常用的集合

 [Java 集合类解析](https://github.com/CyC2018/CS-Notes/blob/master/notes/Java%20%E5%AE%B9%E5%99%A8.md) <br> 


### JAVA 多线程

 [Java 并发编程](https://www.cnblogs.com/wxd0108/p/5479442.html)  <br> 
 [Java 锁解析](https://tech.meituan.com/2018/11/15/java-lock.html) <br> 
 [不得不说的java“锁”事](https://tech.meituan.com/2018/11/15/java-lock.html) <br>

### JAVA I/O

[BIO NIO AIO总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/java/BIO-NIO-AIO.md) <br>


### 类加载机制

  [Java 类加载机制](https://juejin.im/post/5a810b0e5188257a5c606a85) <br>
  [Java Agent 解析](https://www.javazhiyin.com/27630.html)  <br>
  [Java agent源码解析](https://www.infoq.cn/article/javaagent-illustrated) <br>

### 运行时数据区域

 [Java  对象解析](https://blog.csdn.net/smileiam/article/details/80364641) <br>
 [Java JVM内存调优](https://zhanjindong.com/2016/03/02/jvm-memory-tunning-notes) <br>
 [JVM 内存模型](https://juejin.im/post/5ad5c0216fb9a028e014fb63) <br> 
 [JVM内存划分、JVM内存分配机制、JVM垃圾回收机制](https://blog.csdn.net/CSDN_Terence/article/details/77771429) <br>



#### 进程间通信

1. **管道pipe**：管道是一种半双工的通信方式，数据只能单向流动，而且只能在具有亲缘关系的进程间使用。进程的亲缘关系通常是指父子进程关系。
2. **命名管道FIFO**：有名管道也是半双工的通信方式，但是它允许无亲缘关系进程间的通信。
3. **消息队列MessageQueue**：消息队列是由消息的链表，存放在内核中并由消息队列标识符标识。消息队列克服了信号传递信息少、管道只能承载无格式字节流以及缓冲区大小受限等缺点。
4. **共享存储SharedMemory**：共享内存就是映射一段能被其他进程所访问的内存，这段共享内存由一个进程创建，但多个进程都可以访问。共享内存是最快的 IPC 方式，它是针对其他进程间通信方式运行效率低而专门设计的。它往往与其他通信机制，如信号两，配合使用，来实现进程间的同步和通信。
5. **信号量Semaphore**：信号量是一个计数器，可以用来控制多个进程对共享资源的访问。它常作为一种锁机制，防止某进程正在访问共享资源时，其他进程也访问该资源。因此，主要作为进程间以及同一进程内不同线程之间的同步手段。
6. **套接字Socket**：套解口也是一种进程间通信机制，与其他通信机制不同的是，它可用于不同及其间的进程通信。
7. **信号 ( sinal )** ： 信号是一种比较复杂的通信方式，用于通知接收进程某个事件已经发生。