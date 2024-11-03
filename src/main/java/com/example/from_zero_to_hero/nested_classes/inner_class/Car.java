package com.example.from_zero_to_hero.nested_classes.inner_class;

public class Car {
    String color;
    String doorCount;
    Engine engine;

    public Car(String color, String doorCount) {
        this.color = color;
        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsePower);
    }

    public void setEngine(Engine engine) {
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

    public class Engine {
        int horsePower;

        public Engine(int horsePower) {
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
//        Car car = new Car("red", "4", 250);
        Car car = new Car("red", "4");
        Car.Engine engine = car.new Engine( 400);
        car.setEngine(engine);
        System.out.println(car);

        Car.Engine engine2 = new Car("red", "4").new Engine(123);
    }
}
