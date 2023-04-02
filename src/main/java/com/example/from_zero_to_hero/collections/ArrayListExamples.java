package com.example.from_zero_to_hero.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExamples {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder[] array = {sb1, sb2, sb3, sb4};
        List<StringBuilder> list = Arrays.asList(array);
        // длина будет ровно такой же
        System.out.println(list);
//        array[0].append("!!!");
        array[0] = new StringBuilder("F");
        System.out.println(list);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Name1");
        arrayList.add("Name2");
        arrayList.add("Name3");
        arrayList.add("Name4");
        List<String> myList = arrayList.subList(1, 3); // это VIEW
        myList.add("Name5");
        System.out.println(myList);
        System.out.println(arrayList);

        Object[] array1 = arrayList.toArray();
        String[] array2 = arrayList.toArray(new String[5]);

        for (String s : array2) {
            System.out.println(s);
        }
        // не изменяемы и не могут содержать NULL
        // List.of
        // List.copyOf

        List<Integer> list1 = List.of(3, 8, 13);
        System.out.println(list1);

        List<String> list2 = List.copyOf(arrayList);
        System.out.println(list2);
    }
}
