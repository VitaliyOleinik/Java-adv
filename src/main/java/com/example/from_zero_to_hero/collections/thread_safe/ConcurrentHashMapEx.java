package com.example.from_zero_to_hero.collections.thread_safe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) throws InterruptedException {
//        HashMap<Integer, String> hashMap = new HashMap<>();
        ConcurrentHashMap<Integer, String> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1, "Vit");
        hashMap.put(2, "Zan");
        hashMap.put(3, "Sergey");
        hashMap.put(4, "Ivan");
        hashMap.put(5, "Igor");
        System.out.println(hashMap);
        Runnable runnable1 = () -> {
            Iterator<Integer> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer key = iterator.next();
                System.out.println(key + ": " + hashMap.get(key));
            }
        };
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hashMap.put(6, "Elena");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}
