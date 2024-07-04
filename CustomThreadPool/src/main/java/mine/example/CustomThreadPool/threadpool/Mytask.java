package mine.example.CustomThreadPool.threadpool;

public class Mytask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hii" + Thread.currentThread().getName());
    }
}