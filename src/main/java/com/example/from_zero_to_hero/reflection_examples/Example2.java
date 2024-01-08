package com.example.from_zero_to_hero.reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Example2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class employeeClass = Class.forName("com.example.from_zero_to_hero.reflection_examples.Employee");

        Constructor<Employee> constructor1 = employeeClass.getConstructor();
        Employee obj = constructor1.newInstance();

        Constructor constructor2 = employeeClass.getConstructor(int.class,
                String.class, String.class);
        Object obj2 = constructor2.newInstance(5, "Vit", "IT");
        System.out.println(obj2);

        Method method = employeeClass.getMethod("setSalary", double.class);
        method.invoke(obj2, 900000000.00);
        System.out.println(obj2);


    }
}
