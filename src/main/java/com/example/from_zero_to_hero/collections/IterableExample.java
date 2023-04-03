package com.example.from_zero_to_hero.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IterableExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Name1");
        arrayList.add("Name2");
        arrayList.add("Name3");
        arrayList.add("Name4");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(arrayList);
    }
}
