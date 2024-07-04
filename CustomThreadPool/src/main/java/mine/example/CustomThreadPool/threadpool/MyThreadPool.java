package mine.example.CustomThreadPool.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool implements MyExecutorService {
    static int capacity;
    static int currentCapacity;
    static LinkedBlockingQueue<Runnable> linkedBlockingQueue;
    Execution e;

    public MyThreadPool(int capacity) {
        this.capacity = capacity;
        currentCapacity = 0;
        linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        e = new Execution();
    }

    @Override
    public void submit(Runnable r) {
        linkedBlockingQueue.add(r);
        e.executeMyMethod();
    }
}