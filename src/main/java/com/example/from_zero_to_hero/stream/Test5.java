package com.example.from_zero_to_hero.stream;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] array = {9, 5, 3, 8, 1, 7, 0, 6, 2, 4};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));
    }
}
