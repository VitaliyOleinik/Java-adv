package com.example.from_zero_to_hero.lambda;

import java.util.ArrayList;

public class RemoveIf {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hi");
        arrayList.add("poka");
        arrayList.add("ok");
        arrayList.add("Java");
        arrayList.removeIf(element -> element.length() > 3);
        System.out.println(arrayList);
    }
}
