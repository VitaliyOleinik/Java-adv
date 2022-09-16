package com.example.from_zero_to_hero.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1);
        List<Integer> list = stream.filter(element -> {
            System.out.println("!!!");
            return element%2==0;
        }).collect(Collectors.toList());
        System.out.println(list);
    }
}
