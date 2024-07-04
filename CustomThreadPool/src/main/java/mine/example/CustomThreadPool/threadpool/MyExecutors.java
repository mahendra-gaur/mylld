package mine.example.CustomThreadPool.threadpool;

public class MyExecutors {
    int capacity;
    public static MyExecutorService myNewFixedThreadPool(int capacity) {
        return new MyThreadPool(capacity);
    }
}
