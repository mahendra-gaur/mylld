package mine.project.ratelimiter.algorithms.impl;

import java.util.Deque;
import mine.project.ratelimiter.storage.UserSlidingWindowStorage;

public class SlidingWindowCounter {

    private final int maxRequests;
    private final long windowSizeInMillis;
    private final UserSlidingWindowStorage storage;

    public SlidingWindowCounter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.storage = new UserSlidingWindowStorage();
    }

    public boolean isAllowed(String userId) {
        // Get the timestamp deque for the client, creating a new one if it doesn't exist
        Deque<Long> userTimestampQueue = this.storage.getUserQueue(userId);

        Deque<Long> updatedUserTimestampQueue = updateQueue(userTimestampQueue);

        boolean allowedFlag = false;

        // Check if the number of requests in the sliding window exceeds the maximum allowed
        if (updatedUserTimestampQueue.size() < maxRequests) {
            updatedUserTimestampQueue.addLast(System.currentTimeMillis());
            allowedFlag = true; // Request is allowed
        }

        this.storage.updateUserTimeStampQueue(userId, updatedUserTimestampQueue);

        return allowedFlag; // Request is not allowed
    }

    private Deque<Long> updateQueue(Deque<Long> userTimestampQueue){
        long currentTimeMillis = System.currentTimeMillis();
        // Remove timestamps older than the sliding window
        while (
                !userTimestampQueue.isEmpty() &&
                        currentTimeMillis - userTimestampQueue.peekFirst() > windowSizeInMillis) {
            userTimestampQueue.pollFirst();
        }
        return userTimestampQueue;
    }

}
