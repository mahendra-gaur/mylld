package mine.project.ratelimiter.algorithms.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import mine.project.ratelimiter.storage.UserFixedWindowCounterStorage;

public class FixedWindowCounter {
    private final int maxRequestPerWindow;
    private final long windowSizeInMillis;

    private final UserFixedWindowCounterStorage storage;

    public FixedWindowCounter(final int maxRequestPerWindow, final long windowSizeInMillis) {
        this.maxRequestPerWindow = maxRequestPerWindow;
        this.windowSizeInMillis = windowSizeInMillis;
        this.storage = new UserFixedWindowCounterStorage();
    }

    public synchronized boolean isAllowed(String clientId) {
        long currentTimeMillis = System.currentTimeMillis();
        Window window = this.storage.getUserWindow(clientId); // store.get(clientId);

        // If the window doesn't exist or has expired, create a new window
        if (window == null || window.getStartTime() < currentTimeMillis - windowSizeInMillis) {
            window = new Window(currentTimeMillis, 0);
        }

        // Check if the number of requests in the window exceeds the maximum allowed
        if (window.getRequestCount() >= maxRequestPerWindow) {
            this.storage.saveUserWindow(clientId, window);
            return false; // Request is not allowed
        }

        // Increment the request count and update the window in the store
        window.setRequestCount(window.getRequestCount() + 1);

        this.storage.saveUserWindow(clientId, window);

        return true; // Request is allowed
    }

}
