package com.example.from_zero_to_hero.generics;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        //List<Object> list = new ArrayList<Integer>(); // нельзя так писать
        List<?> list = new ArrayList<Integer>();
//        list.add("hello"); -> так нельзя, так как основной принцип type safe

        List<? extends Number> list30 = new ArrayList<Integer>();
        List<? super Number> list31 = new ArrayList<Object>();

        List<Double> list1 = new ArrayList<>();
        list1.add(3.12);
        list1.add(3.15);
        list1.add(3.13);
        showListInfo(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Privet");
        list2.add("Poka");
        list2.add("Ok");
        showListInfo(list2);

        ArrayList<Double> ald = new ArrayList<>();
        ald.add(3.12);
        ald.add(3.15);
        ald.add(3.13);
        System.out.println(sum(ald));

        ArrayList<Integer> ali = new ArrayList<>();
        ali.add(312);
        ali.add(315);
        ali.add(313);
        System.out.println(sum(ali));
    }

    static void showListInfo(List<?> list) {
        System.out.println(list);
    }

    public static double sum(ArrayList<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}

