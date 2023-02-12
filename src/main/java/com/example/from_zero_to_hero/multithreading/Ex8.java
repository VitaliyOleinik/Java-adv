package com.example.from_zero_to_hero.multithreading;

public class Ex8 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i ++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable1());
        Ex8 thread2 = new Ex8();
        thread1.start();
        thread2.start();

        thread1.join(); // будет ожидать окончание работы thread1
        thread2.join(); // будет ожидать окончание работы thread2
        System.out.println("End!");
    }
}

class MyRunnable1 implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i ++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
