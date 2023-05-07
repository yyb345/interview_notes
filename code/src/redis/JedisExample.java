package redis;

import redis.clients.jedis.Jedis;

public class JedisExample {

    static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println("t1");
        }
    }

    static class T2 extends Thread{
        @Override
        public void run() {
           System.out.println("t2");
        }
    }

    public static void main(String[] args) {
        // 创建 Jedis 客户端对象，连接本地 Redis 服务器
        Jedis jedis1 = new Jedis("localhost");
        Jedis jedis2 = new Jedis("localhost");



        Thread t1 = new Thread(() -> {
            DistributedLock distributedLock= new DistributedLock(jedis1,"k1","1",200);
            if(distributedLock.tryLock()){
                System.out.println("t1");
                distributedLock.releaseLock();
            }
        });
        t1.setName("t1");


        Thread t2 = new Thread(() -> {
            DistributedLock distributedLock= new DistributedLock(jedis2,"k1","1",200);
            if(distributedLock.tryLock()){
                System.out.println("t2");
                distributedLock.releaseLock();
            }
        });

        t2.setName("t2");






//        boolean b = distributedLock.tryLock();

        // 将字符串类型的值设置到 Redis 中
        //jedis.set("name", "Tom");

        // 从 Redis 中获取字符串类型的值
//        String value = jedis.get("name");
//        System.out.println("value: " + value);

        // 关闭 Jedis 客户端连接

        try {

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            jedis1.close();
            jedis2.close();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}





