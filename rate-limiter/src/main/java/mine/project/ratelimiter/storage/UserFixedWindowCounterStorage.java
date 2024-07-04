package mine.project.ratelimiter.storage;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import mine.project.ratelimiter.algorithms.impl.Window;

public class UserFixedWindowCounterStorage {

    private final ConcurrentMap<String, Window> store;

    public UserFixedWindowCounterStorage() {
        this.store = new ConcurrentHashMap<>();
    }

    public Window getUserWindow(String userId) {
        Window window = store.get(userId);
        return window;
    }

    public void saveUserWindow(String userId, Window window) {

    }

}
