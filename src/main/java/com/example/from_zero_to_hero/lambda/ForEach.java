package com.example.from_zero_to_hero.lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<String> list = List.of("hi", "ok", "how are you", "bye");
        for (String s: list) {
            System.out.println(s);
        }
        list.forEach(str -> System.out.println(str));

        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-");

        List<Integer> list2 = new ArrayList<>();
        list2.add(27);
        list2.add(25);
        list2.add(24);
        list2.add(23);
        list2.add(22);
        list2.add(21);

        list2.forEach(el -> {System.out.print(el + " * 2 = ");
            el *= 2;
            System.out.println(el);});
    }
}
