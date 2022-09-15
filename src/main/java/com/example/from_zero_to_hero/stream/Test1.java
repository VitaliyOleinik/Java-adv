package com.example.from_zero_to_hero.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ok");
        list.add("privet");
        list.add("kak dela?");
        list.add("poka");

//        for (int i = 0; i < list.size(); i ++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }

        List<Integer> list1 = list.stream().map(element -> element.length())
                .collect(Collectors.toList());

        System.out.println(list);

        int[] array = {5, 9, 8, 7, 6, 5, 3};
        int [] array1 = Arrays.stream(array).map(element
                -> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
        System.out.println(Arrays.toString(array1));
    }
}
