package com.example.from_zero_to_hero.nested_classes.static_nested_class;

public class Car {
    String color;
    String doorCount;
    Engine engine;
    private static int a;

    public Car(String color, String doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car{" +
                "color='" + color + '\'' +
                ", doorCount='" + doorCount + '\'' +
                ", engine=" + engine +
                '}';
    }

    public static class Engine {
        int horsePower;

        public Engine(int horsePower) {
            System.out.println(a);
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "My engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine(1000);
        Car car = new Car("red", "4", engine);
        System.out.println(car);
    }
}