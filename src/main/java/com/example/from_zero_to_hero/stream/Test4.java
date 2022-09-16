package com.example.from_zero_to_hero.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int result = list.stream().reduce((accumulator, element) ->
                accumulator * element).get();
        System.out.println("Result1 = " + result);
        // 5  1  2  3  4
        // accumulator  5  5  10  30   120
        // element      1  2  3   4

        // example with identity
        int result2 = list.stream().reduce(1, (accumulator, element) ->
                accumulator * element);
        System.out.println("Result2 = " + result2);

        // example with String -> concatenation all elements
        List<String> list3 = new ArrayList<>();
        list3.add("Ok");
        list3.add("Privet");
        list3.add("Poka");
        list3.add("Kak ty?");

        String result3 = list3.stream().reduce((accumulator, element) -> accumulator + " " + element).get();
        System.out.println("Result3 = " + result3);

        // example with Optional
        List<Integer> list100 = new ArrayList<>();
        Optional<Integer> o = list100.stream().reduce((accumulator, element) -> accumulator * element);
        if (o.isPresent()) {
            o.get();
        } else {
            System.out.println("Result4 = " + "Not present");
        }
    }
}
