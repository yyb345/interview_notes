package redis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;


public class RedisTypeExample {


    @Test
    void hashSupportTest(){
        Jedis jedis = new Jedis("localhost");
        jedis.hset("k","k1","v1");
        jedis.hset("k","k2","v2");

        Map<String, String> map = jedis.hgetAll("k");


        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
