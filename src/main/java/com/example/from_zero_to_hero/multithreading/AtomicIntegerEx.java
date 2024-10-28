package com.example.from_zero_to_hero.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {
    //    static int counter = 0;
    static AtomicInteger counter = new AtomicInteger(0);

    public synchronized static void increment() {
//        counter++;
//        counter.incrementAndGet();
        counter.addAndGet(-50);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable118());
        Thread t2 = new Thread(new MyRunnable118());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }
}

class MyRunnable118 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            AtomicIntegerEx.increment();
        }
    }
}
