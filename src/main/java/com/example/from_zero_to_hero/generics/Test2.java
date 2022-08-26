package com.example.from_zero_to_hero.generics;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
//        X x = new Y();
//        List<X> list1 = new ArrayList<X>();
//        Info1<Integer> info = new Info1<>(1);
//        Info1<Double> info1 = new Info1<>(1.2);
    }
}

class X{

}

class Y extends X {

}

class Info1 <T extends Number&I1&I2> {
    private T value;
    public Info1(T value) {
        this.value = value;
    }
    public String toString() {
        return "{" + value + "}";
    }
    public T getValue() {
        return value;
    }
}

class GenMethodExtendsNumber {
    public static <T extends Number> T getSecondElement(ArrayList<T> a1) {
        return a1.get(1);
    }
}

interface I1{}
interface I2{}
