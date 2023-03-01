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
