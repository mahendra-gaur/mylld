package com.example.my_concurrency.leetcode;

import java.util.concurrent.Semaphore;

public class Print_in_Order_1114 {

    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(0);

    private Semaphore sem3 = new Semaphore(1);
    private Semaphore sem4 = new Semaphore(0);


    public Print_in_Order_1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        sem1.acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sem2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
                                            sem2.acquire();
        sem3.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
                                            sem1.release();
        sem4.release();

    }

    public void third(Runnable printThird) throws InterruptedException {
        sem4.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        sem3.release();
    }

}
