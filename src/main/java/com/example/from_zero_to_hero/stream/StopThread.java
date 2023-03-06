package com.example.from_zero_to_hero.stream;

public class StopThread extends Thread
{
    @Override
    public void run() {
        while (!Thread.interrupted()) {     //check for interrupted status
            System.out.println("Thread is running...");
        }
        System.out.println("Thread stopped!!!");
    }
}

class Main {
    public static void main(String[] args) {
        //create a thread instance
        StopThread stop_thread = new StopThread();
        //start the thread
        stop_thread.start();

        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //interrupt the thread
        stop_thread.interrupt();
    }
}
