package mine.example.CustomThreadPool.threadpool;

public class Execution implements Runnable {
    void executeMyMethod() {
        if (MyThreadPool.currentCapacity < MyThreadPool.capacity) {
            MyThreadPool.currentCapacity++;
            Thread t = new Thread(new Execution());
            t.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (MyThreadPool.linkedBlockingQueue.size() != 0) {
                MyThreadPool.linkedBlockingQueue.poll().run();
            }
        }
    }
}