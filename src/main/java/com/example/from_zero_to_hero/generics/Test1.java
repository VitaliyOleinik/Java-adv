package com.example.from_zero_to_hero.generics;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        list.add("Ok");
//        list.add(5);
//        list.add(new StringBuilder());
        list.add("privet");
        list.add("poka");
        list.add("kak ty?");
        list.add("ok");

        for (Object o: list) {
            System.out.println(o + " dlina " + ((String)o).length());
        }

    }
}
