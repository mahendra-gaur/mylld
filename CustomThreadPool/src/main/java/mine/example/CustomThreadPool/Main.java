package mine.example.CustomThreadPool;

import mine.example.CustomThreadPool.threadpool.MyExecutorService;
import mine.example.CustomThreadPool.threadpool.Mytask;
import mine.example.CustomThreadPool.threadpool.MyExecutors;

public class Main {

    public static void main(String[] args) {
        MyExecutorService service = MyExecutors.myNewFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            service.submit(new Mytask());
        }
    }
}
