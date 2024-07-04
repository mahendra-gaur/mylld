package mine.project.ratelimiter.storage;

import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Component;

public class UserSlidingWindowStorage {

    private final ConcurrentMap<String, Deque<Long>> userTimestampMap;

    public UserSlidingWindowStorage() {
        this.userTimestampMap = new ConcurrentHashMap<>();
    }

    public Deque<Long> getUserQueue(String userId) {
        Deque<Long> userTimestampQueue = this.userTimestampMap.computeIfAbsent(
                userId, k -> new ConcurrentLinkedDeque<>());
        return userTimestampQueue;
    }

    public void updateUserTimeStampQueue(String userId, Deque<Long> updatedUserTimeStampQueue) {
        this.userTimestampMap.put(userId, updatedUserTimeStampQueue);
    }

}
