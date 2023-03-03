package com.example.from_zero_to_hero;

public class ThreadExamples {
    public static void main(String[] args) {
        ThreadExampleName threadExampleName = new ThreadExampleName();
        threadExampleName.run();
    }
}

class ThreadExampleName implements Runnable {
    @Override
    public void run() {
        System.out.println("Doing heavy processing - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Doing heavy processing - END "+Thread.currentThread().getName());

    }

    private void doDBProcessing() throws InterruptedException {
        Thread.sleep(5000);
    }
}

class Main extends Thread {
    public static int amount = 0;

    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();
        // Wait for the thread to finish
        while(thread.isAlive()) {
            System.out.println("Waiting...");
        }
        // Update amount and print its value
        System.out.println("Main: " + amount);
        amount++;
        System.out.println("Main: " + amount);
    }
    public void run() {
        amount++;
    }
}
