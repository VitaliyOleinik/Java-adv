package com.example.from_zero_to_hero.multithreading;

public class Ex9 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState()); // NEW
        thread.start();
        System.out.println(thread.getState()); // RUNNABLE
        thread.join(1500); // либо пока не завершит thread свою работу
                                // либо пока не пройдет 1500 ms
        System.out.println(thread.getState()); // TERMINATED
        System.out.println("Method main ends");
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work ends");
    }
}
