package com.example.from_zero_to_hero.multithreading;

public class Ex4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Privet");
            }
        }).start();

        new Thread(() -> System.out.println("privet")).start();
    }
}
