package com.example.my_concurrency.leetcode;

import java.util.concurrent.Semaphore;

public class Building_H2O_11117 {

    private Semaphore oxygen = new Semaphore(0);
    private Semaphore hydrogen = new Semaphore(2);

    public Building_H2O_11117() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
    }

}
