package com.example.from_zero_to_hero.reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class employeeClass = Class.forName("com.example.from_zero_to_hero.reflection_examples.Employee");
//        Class employeeClass2 = Employee.class;
//        Employee emp = new Employee();
//        Class employeeClass3 = emp.getClass();
        Field someField = employeeClass.getField("id");
        System.out.println("Type of id field = " + someField.getType());
        System.out.println("-----------------------------------------");
        Field[] fields = employeeClass.getFields();
        for (Field field : fields) {
            System.out.println("Type of " + field.getName() + " type is " + field.getType());
        }

        Field[] allFields = employeeClass.getDeclaredFields();
        for (Field field : allFields) {
            System.out.println("Type of " + field.getName() + " type is " + field.getType());
        }
        System.out.println("-----------------------------------------");
        Method someMethod1 = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method increaseSalary = " +
                someMethod1.getReturnType() + ", parameter types = " +
                Arrays.toString(someMethod1.getParameterTypes()));
        System.out.println("-----------------------------------------");
        Method someMethod2 = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method increaseSalary = " +
                someMethod2.getReturnType() + ", parameter types = " +
                Arrays.toString(someMethod2.getParameterTypes()));
        System.out.println("-----------------------------------------");
        Method[] methods = employeeClass.getMethods();
        for (Method method : methods) {
            System.out.println("Name of method " + method.getName() +
                    " Return type of method = " +
                    method.getReturnType() + ", parameter types = " +
                    Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("-----------------------------------------");
        Method[] allMethods = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println("Name of method " + method.getName() +
                    " Return type of method = " +
                    method.getReturnType() + ", parameter types = " +
                    Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("-----------------------------------------");
        Method[] allMethods2 = employeeClass.getDeclaredMethods();
        for (Method method : allMethods2) {
            if (Modifier.isPublic(method.getModifiers()))
                System.out.println("Name of method " + method.getName() +
                        " Return type of method = " +
                        method.getReturnType() + ", parameter types = " +
                        Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("-----------------------------------------");
        for (Method method : allMethods2) {
            if (Modifier.isPublic(method.getModifiers()))
                System.out.println("Name of method " + method.getName() +
                        " Return type of method = " +
                        method.getReturnType() + ", parameter types = " +
                        Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("-----------------------------------------");
        Constructor constructor1 = employeeClass.getConstructor();
        System.out.println("Constructor has " + constructor1.getParameterCount() +
                " parameters, their types are: " +
                Arrays.toString(constructor1.getParameterTypes()));

        System.out.println("-----------------------------------------");
        Constructor constructor2 = employeeClass.getConstructor(int.class,
                String.class, String.class);
        System.out.println("Constructor has " + constructor2.getParameterCount() +
                " parameters, their types are: " +
                Arrays.toString(constructor2.getParameterTypes()));

        System.out.println("-----------------------------------------");
        Constructor [] constructors = employeeClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("name: " + constructor.getName() +
                    " Constructor has " + constructor.getParameterCount() +
                    " parameters, their types are: " +
                    Arrays.toString(constructor.getParameterTypes()));
        }

    }
}
