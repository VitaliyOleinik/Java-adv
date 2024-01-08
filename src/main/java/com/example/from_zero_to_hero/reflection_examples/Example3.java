package com.example.from_zero_to_hero.reflection_examples;

import java.lang.reflect.Field;

public class Example3 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Employee employee = new Employee(10, "Vit", "IT");
        Class employeeClass = employee.getClass();
        Field field = employeeClass.getDeclaredField("salary");
        field.setAccessible(true);
        double salaryField = (Double) field.get(employee);
        System.out.println(salaryField);

        field.set(employee, 1500);
        System.out.println(employee);
    }
}
