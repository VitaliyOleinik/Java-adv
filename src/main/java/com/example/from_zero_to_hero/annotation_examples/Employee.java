package com.example.from_zero_to_hero.annotation_examples;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation
public class Employee {
//    @MyAnnotation
    String name;
    double salary;

//    @MyAnnotation
    public Employee(String name, /*@MyAnnotation*/ double salary) {
        this.name = name;
        this.salary = salary;
    }

    @MyAnnotation
    public void increaseSalary() {
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Employee : " + name + ", salary : " + salary;
    }
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME) // жизненный цикл
@interface MyAnnotation {

}
