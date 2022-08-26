package com.example.from_zero_to_hero.comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List <String> list = new ArrayList<>();
        list.add("Vit");
        list.add("Petya");
        list.add("Ivan");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
