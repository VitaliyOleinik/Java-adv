package com.example.from_zero_to_hero.regex;

import java.util.Arrays;

public class Regex3 {
    public static void main(String[] args) {
        String s = "ajfkjakjdk vit@gmail.com sdfksdk ";

        String s2 = "vit@gmail.com"; // для одного значения
        boolean result = s2.matches("\\w+@\\w+\\.(com|ru)");
        System.out.println(result);

        String [] array = s.split(" ");
        System.out.println(Arrays.toString(array));
    }
}
