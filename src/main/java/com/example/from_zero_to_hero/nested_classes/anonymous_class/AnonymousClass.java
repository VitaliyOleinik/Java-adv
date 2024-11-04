package com.example.from_zero_to_hero.nested_classes.anonymous_class;

public class AnonymousClass {
    public static void main(String[] args) {
        Math m = new Math() {
            int c = 10;

            void abc() {
                System.out.println(c);
            }

            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };
        System.out.println(m.doOperation(1, 2));

        Math m2 = new Math() {
            int c = 10;

            void abc() {
                System.out.println(c);
            }

            @Override
            public int doOperation(int a, int b) {
                return a * b;
            }
        };
        System.out.println(m2.doOperation(10, 6));
    }
}

class Math {
    int doOperation(int a, int b) {
        return a + b;
    }
}
