package com.example.from_zero_to_hero.stream;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Arrays.stream(array).forEach(element -> {
            System.out.print(element + " * 2 = ");
            element *= 2;
            System.out.println(element);
        });

        Arrays.stream(array).forEach(el -> System.out.println(el));
        Arrays.stream(array).forEach(System.out::println); // :: reference
        Arrays.stream(array).forEach(Utils::myMethod); // :: reference
    }
}

class Utils{
    public static void myMethod(int a) {
        a += 5;
        System.out.println("element = " + a);
    }
}
