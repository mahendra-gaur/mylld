package mine.project.ratelimiter.algorithms.impl;

import java.util.concurrent.atomic.AtomicLong;

public class LeakyBucket {
    // represents the maximum number of requests that the bucket can hold.
    private final long capacity;

    // specifies the rate at which requests are released from the bucket.
    private final long ratePerSecond;

    // it stores the timestamp of the last processed request.
    private final AtomicLong lastRequestTime;

    // it tracks the current number of requests in the bucket.
    private final AtomicLong currentBucketSize;

    public LeakyBucket(long capacity, long ratePerSecond) {
        this.capacity = capacity;
        this.ratePerSecond = ratePerSecond;
        this.lastRequestTime = new AtomicLong(System.currentTimeMillis());
        this.currentBucketSize = new AtomicLong(0);
    }

    public synchronized boolean isAllowed() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastRequestTime.getAndSet(currentTime);

        // Calculate the amount of tokens leaked since the last request
        long leakedTokens = elapsedTime * ratePerSecond / 1000;
        currentBucketSize.updateAndGet(bucketSize ->
                Math.max(0, Math.min(bucketSize + leakedTokens, capacity)));

        // Check if a request can be processed by consuming a token from the bucket
        if (currentBucketSize.get() > 0) {
            currentBucketSize.decrementAndGet();
            return true; // Request is allowed
        }

        return false; // Request is not allowed
    }

}
