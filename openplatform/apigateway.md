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

## 数据中心

SLS->Flink->hologress   

## what can we learn from it？
