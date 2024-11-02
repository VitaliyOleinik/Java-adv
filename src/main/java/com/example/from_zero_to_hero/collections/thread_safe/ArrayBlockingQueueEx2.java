package com.example.from_zero_to_hero.collections.thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueEx2 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue
                = new ArrayBlockingQueue<>(4);
        // Producer
        new Thread(() ->{
            int i = 0;
            while(true){
                try {
                    arrayBlockingQueue.put(++i);
                    System.out.println("Producer add number: " + i + " array: " + arrayBlockingQueue);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // Consumer
        new Thread(() ->{
            while(true){
                try {
                    Integer i = arrayBlockingQueue.take();
                    System.out.println("Consumer takes number: " + i + " array: " + arrayBlockingQueue);
                    System.out.println();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
