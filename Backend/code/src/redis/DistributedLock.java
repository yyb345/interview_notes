package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

public class DistributedLock {
    private final Jedis jedis;
    private final String lockKey;
    private final String lockValue;
    private final long lockExpireTime;

    public DistributedLock(Jedis jedis, String lockKey, String lockValue, long lockExpireTime) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.lockValue = lockValue;
        this.lockExpireTime = lockExpireTime;
    }

    public boolean tryLock() {
        SetParams setParams = new SetParams();
        setParams.nx();
        setParams.ex(lockExpireTime);
        String name = Thread.currentThread().getName();
        String result = jedis.set(lockKey, lockValue, setParams);
        return "OK".equals(result);
    }

    public void releaseLock() {
        jedis.eval("if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end",
                1, lockKey, lockValue);
    }
}

