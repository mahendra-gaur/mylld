package com.example.my_concurrency.leetcode;

import java.util.concurrent.Semaphore;

public class Print_FooBar_Alternately_1115 {
    private int n;

    private Semaphore sem1 = new Semaphore(1);
    private Semaphore sem2 = new Semaphore(0);

    public Print_FooBar_Alternately_1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sem1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            sem2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            sem2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            sem1.release();
        }
    }

}
