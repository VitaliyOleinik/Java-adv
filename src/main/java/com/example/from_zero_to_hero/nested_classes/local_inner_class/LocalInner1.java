package com.example.from_zero_to_hero.nested_classes.local_inner_class;

public class LocalInner1 {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult(4, 2);
    }
}

class Math {
    public void getResult(final int a, final int b) {
        class Divide {
//            private int a, b;

            /*public Divide(int a, int b) {
                this.a = a;
                this.b = b;
            }*/

            public int result() {
                return a / b;
            }
        }

        Divide divide = new Divide();
        System.out.println(divide.result());

    }

    ;
}
