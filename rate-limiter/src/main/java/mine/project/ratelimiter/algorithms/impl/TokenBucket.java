package mine.project.ratelimiter.algorithms.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {

    // represents the maximum number of tokens the bucket can hold.
    private final long capacity;

    // it keeps track of the number of available tokens in the bucket.
    private final AtomicLong tokens;

    // it is the duration between token refills.
    private final Duration refillPeriod;

    // it stores the instant of the last token refill.
    private volatile Instant lastRefillTime;

    public TokenBucket(long capacity, Duration refillPeriod) {
        this.capacity = capacity;
        this.tokens = new AtomicLong(capacity);
        this.refillPeriod = refillPeriod;
        this.lastRefillTime = Instant.now();
    }

    public synchronized boolean isAllowed() {
        refillTokens();

        long currentTokens = tokens.get();
        if (currentTokens > 0) {
            tokens.decrementAndGet();
            return true; // Request is allowed
        }

        return false; // Request is not allowed
    }

    /**
     * Refills tokens in the token bucket based on the refill period.
     */
    private synchronized void refillTokens() {
        Instant now = Instant.now();
        long timeElapsed = Duration.between(lastRefillTime, now).toMillis();
        long tokensToAdd = timeElapsed / refillPeriod.toMillis();

        if (tokensToAdd > 0) {
            lastRefillTime = now;
            tokens.getAndUpdate(currentTokens -> Math.min(capacity, currentTokens + tokensToAdd));
        }
    }

}
