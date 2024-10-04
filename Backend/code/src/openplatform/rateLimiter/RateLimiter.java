package openplatform.rateLimiter;

import java.util.concurrent.*;

/**
 * 这段代码是限流，采用令牌桶算法
 */
public class RateLimiter {
    private final long capacity;
    private final long refillTokensPerPeriod;
    private final long period;
    private long tokens;
    private long lastRefillTimestamp;

    public RateLimiter(long capacity, long refillTokensPerPeriod, long period, TimeUnit unit) {
        this.capacity = capacity;
        this.refillTokensPerPeriod = refillTokensPerPeriod;
        this.period = unit.toNanos(period);
        this.tokens = capacity;
        this.lastRefillTimestamp = System.nanoTime();
    }

    public synchronized boolean tryAcquire() {
        refill();
        if (tokens > 0) {
            tokens--;
            return true;
        } else {
            return false;
        }
    }

    private void refill() {
        long now = System.nanoTime();
        if (now > lastRefillTimestamp + period) {
            long elapsedPeriods = (now - lastRefillTimestamp) / period;
            tokens = Math.min(capacity, tokens + elapsedPeriods * refillTokensPerPeriod);
            lastRefillTimestamp = now;
        }
    }
}

