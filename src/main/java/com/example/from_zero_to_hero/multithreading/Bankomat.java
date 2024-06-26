package com.example.from_zero_to_hero.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Employee("Zaur", lock);
        new Employee("Vit", lock);
        new Employee("Zan", lock);
        Thread.sleep(7000);
        new Employee("Art", lock);
        new Employee("Dan4ik", lock);
    }
}

class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.lock = lock;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {
        if (lock.tryLock()) {
            try {
                System.out.println(name + " ждёт ");
                lock.lock();
                System.out.println(name + " пользуется банкоматом ");
                Thread.sleep(2000);
                System.out.println(name + " работник завершил свои дела ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " не хочет ждать в очереди и ушел!");
        }
    }
}
