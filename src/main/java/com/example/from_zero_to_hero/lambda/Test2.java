package com.example.from_zero_to_hero.lambda;

public class Test2 {
    static void def(I i) {
        System.out.println(i.abc("Privet"));
    }

    static void pef(С с) {
        System.out.println(с.abc());
    }

    public static void main(String[] args) {
        def( (String s) -> {return s.length();} );
        pef( () -> {return 42;} );
        pef( () -> 42 );
    }
}

interface I {
    int abc(String s);
}

interface С {
    int abc();
}
