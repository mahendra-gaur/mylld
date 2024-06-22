package com.example.experiments;

import java.util.concurrent.Semaphore;

public class MySemaphore {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        semaphore.release();
        semaphore.release();
        System.out.println();
        semaphore.acquire();

        System.out.println();
    }

}
