## 网关技术架构

 <div style="text-align: center;">  
    <img src="https://github.com/user-attachments/assets/452505a2-6ade-414a-adff-d837e9ec2db9" alt="image" style="width: 300px; height: auto;" />  
</div>
  

## 核心指标

性能指标：RT 、吞吐量QPS
稳定性指标：SLA可用性4个9
业务指标：API的成功率

## 核心技术点

异步化：HSF异步化/Jetty异步
多层元数据缓存：bloomfiter/ 本地缓存/分布式缓存
流控：令牌桶算法 / 漏桶算法

安全：收货地址、手机号、姓名等进行加密、解密

## 数据中心

SLS->Flink->hologress   

API维度、应用维度、商家维度、API-应用维度

分钟级、天级

FlinkSQL技术栈



## API控制台

API DevOps平台、API文档生成、API文档搜索（OpenSearch）

## SDK技术

GO语言、Java语言、Python语言、Net语言、C++语言等

基础包：HTTP调用、参数拼接、签名计算、返回结果反序列化

个性化包：DSL+模版引擎=> 代码生成

## 授权技术

服务端授权：code换token



## 与开源框架Spring Cloud Gateway的对比

业务上：电商业务

技术上：Spring体系与技术框架，底层采用netty网络IO框架，异步框架是Project Reactor

路由规则是硬编码或Yaml文件、后端集成eraka foreign

## 与Service Mesh的对比

一个是横向（东西）的流量、一个是纵向（南北）的流量

一个是业务网关 一个是微服务的流量网关
