package com.example.from_zero_to_hero.generics;

public class ParameterizedClass {
    public static void main(String[] args) {
        Info<String> info1 = new Info<>("privet");
        System.out.println(info1);
        String s = info1.getValue();

        Info<Integer> info2 = new Info<>(123);
        System.out.println(info2);
        Integer i2 = info2.getValue();
    }

//    public void abc(Info<String> info) {
//        String s = info.getValue();
//    }
//
//    public void abc(Info<Integer> info) {
//        Integer s = info.getValue();
//    }
//
//    // Exception abc(Info info)



}

class Info <T> {
    private T value;
    public Info(T value) {
        this.value = value;
    }
    public String toString() {
        return "{" + value + "}";
    }
    public T getValue() {
        return value;
    }
}

//class Parent {
//    public void abc(Info<String> info) {
//        String s = info.getValue();
//    }
//}
//
//class Child extends Parent {
//    public void abc(Info<Integer> info) {
//        Integer s = info.getValue();
//    }
//}
// Exception -> abc(Info info) in JVM code