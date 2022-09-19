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

        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream3 = Stream.of(9,8,7,6,5,4,3,2,1);
        Stream<Integer> stream4 = Stream.concat(stream2, stream3);
        stream4.forEach(System.out::println);

        Stream<Integer> stream5 = Stream.of(1,2,3,4,5,6,7,8,9,1,2,3,4,5);
        stream5.distinct().forEach(System.out::println);

        System.out.println(stream5.count());
        System.out.println(stream5.distinct().count());
        // выведет ошибку, стримы нельзя переиспользовать!
    }
}
