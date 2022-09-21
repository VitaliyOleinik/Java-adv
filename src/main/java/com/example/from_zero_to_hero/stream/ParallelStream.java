package com.example.from_zero_to_hero.stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(100000.0);
        list.add(20.0);
        list.add(14.0);
        list.add(5.0);
        list.add(65.0);
        double sumResult = list.stream().reduce((accumulator, element)->accumulator+element).get();
        System.out.println("sumResult: " + sumResult);

        double divisionResult = list.stream().reduce((accumulator, element)->accumulator/element).get();
        System.out.println("divisionResult: " + divisionResult);
    }
    // 1 2 3 4 5 ... 1000000000
    // 1 - 0             250 000 000
    // 2 - 250 000 001   500 000 000
    // 3 - 500 000 001   750 000 000
    // 4 - 750 000 001   1 000 000 000
}
