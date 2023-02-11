package com.example.from_zero_to_hero.multithreading;

public class Ex5 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        MyThread5 myThread6 = new MyThread5();
        myThread5.setName("moi potok");
        myThread5.setPriority(10); // Thread.MAX_PRIORITY
        System.out.println("name of thread = " + myThread5.getName() +
                " priority of thread = " + myThread5.getPriority());
        System.out.println("name of thread = " + myThread6.getName() +
                " priority of thread = " + myThread6.getPriority());
    }
}

class MyThread5 extends Thread {
    public void run() {
        System.out.println("privet");
    }
}
