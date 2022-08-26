package com.example.from_zero_to_hero.generics;

import java.util.ArrayList;

public class ParameterizedMethod {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(12);
        al1.add(13);
        al1.add(14);
        int a = GenMethod.getSecondElement(al1);
        ArrayList<String> al2 = new ArrayList<>();
        al2.add("privet");
        al2.add("poka");
        al2.add("kak ty?");
        String a1 = GenMethod.getSecondElement(al2);
        System.out.println(a + "\n" + a1);
    }
}

class GenMethod {
    public static <T> T getSecondElement(ArrayList<T> a1) {
        return a1.get(1);
    }
}
