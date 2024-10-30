package com.example.from_zero_to_hero.collections.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollection {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            source.add(i);
        }

//        ArrayList<Integer> target = new ArrayList<>();
        List<Integer> synchList =
                Collections.synchronizedList(new ArrayList<>()); // тут есть Lock,
                                                                 // пока один поток работу не закончит,
                                                                 // второй не начнет работу

//        Runnable runnable = () ->{target.addAll(source);};
        Runnable runnable = () ->{synchList.addAll(source);};

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join(); // для ожидания гавного потока main, чтобы потоки прошли обработку
        thread2.join(); // для ожидания гавного потока main, чтобы потоки прошли обработку
        System.out.println(synchList);
    }
}
