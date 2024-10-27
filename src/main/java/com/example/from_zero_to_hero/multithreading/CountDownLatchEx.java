package com.example.from_zero_to_hero.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown();
        System.out.println("countDownLatch " + countDownLatch.getCount());
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready, so let's open market");
        countDownLatch.countDown();
        System.out.println("countDownLatch " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is opened");
        countDownLatch.countDown();
        System.out.println("countDownLatch " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        new Friend("Vit", countDownLatch);
        new Friend("Zan", countDownLatch);
        new Friend("Caroline", countDownLatch);
        new Friend("Dan", countDownLatch);
        new Friend("Dias", countDownLatch);

        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();

    }
}

class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch1;

    public Friend(String name, CountDownLatch countDownLatch1) {
        this.countDownLatch1 = countDownLatch1;
        this.name = name;
        this.start();
    }

    public void run() {
        try {
            countDownLatch1.await();
            System.out.println(name + " is ready to buy");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


