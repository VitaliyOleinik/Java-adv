package com.example.from_zero_to_hero.stream;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] array = {9, 5, 3, 8, 1, 7, 0, 6, 2, 4};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));

        // Chaining methods
        int result = Arrays.stream(array).filter(element -> element % 2 == 1)
                .map(element -> {
                    if (element % 3 == 0) {
                        element = element / 3;
                    }
                    return element;
                })
                .reduce((accumulator, element) -> accumulator + element).getAsInt();
        System.out.println("Result of chaining methods: " + result);
        // 9 5 3 1 7
        // 3 5 1 1 7
        // 17
    }
}
