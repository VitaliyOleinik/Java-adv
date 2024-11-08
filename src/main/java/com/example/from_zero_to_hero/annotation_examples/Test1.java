package com.example.from_zero_to_hero.annotation_examples;

public class Test1 {
    public static void main(String[] args) {
        Parent p = new Child("Vit");
        p.showInfo();
    }
}

class Parent {
    String name;

    public Parent(String name) {
        this.name = name;
    }

    void showInfo() {
        System.out.println("It's Parent class Name: " + name);
    }
}

class Child extends Parent {
    public Child(String name) {
        super(name);
    }

    @Override
    void showInfo() {
        System.out.println("It's Child class Name: " + name);
    }
}
