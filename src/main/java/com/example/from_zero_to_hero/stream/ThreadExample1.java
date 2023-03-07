package com.example.from_zero_to_hero.stream;

import java.io.IOException;


class First implements Runnable {
    Thread t;
    String s;

    First(String Name) {
        s = Name;
        t = new Thread(this, s);
        System.out.println("CHILD :" + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(s + " :" + i);
                Thread.sleep(1000);
            }
        } //END OF TRY BLOCK
        catch (InterruptedException e) {
        }
        System.out.println("EXITING " + s);
    }
}

class Second {
    public static void main(String[] args) throws IOException {
        new First("ONE");
        new First("TWO");
        new First("THREE");
        try {
            Thread.sleep(20000);
        } //END OFTRY BLOCK
        catch (InterruptedException e) {
        }
        System.out.println("EXITING MAIN");
    }
}
