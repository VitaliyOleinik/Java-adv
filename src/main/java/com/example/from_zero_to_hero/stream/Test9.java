package com.example.from_zero_to_hero.stream;

import java.util.ArrayList;
import java.util.List;

public class Test9 {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Kit", 'f', 52, 4, 5.3);
        Student student5 = new Student("Hello", 'm', 12, 1, 3.3);
        Student student6 = new Student("Efdov", 'm', 12, 1, 3.3);
        Student student3 = new Student("Andr", 'm', 12, 1, 3.3);
        Student student4 = new Student("Ketto", 'f', 44, 2, 9.3);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

//        Student min = students.stream().min((x,y)-> x.getAge() - y.getAge()).get();
//        System.out.println(min);
//
//        Student max = students.stream().max((x,y)-> x.getAge() - y.getAge()).get();
//        System.out.println(max);

        students.stream().filter(e->e.getAge()>20).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        students.stream().filter(e->e.getAge()>20).limit(2).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        students.stream().filter(e->e.getAge()>20).skip(2).forEach(System.out::println);
    }
}
