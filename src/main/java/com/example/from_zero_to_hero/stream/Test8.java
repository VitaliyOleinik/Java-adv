package com.example.from_zero_to_hero.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test8 {
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

//        Map<Integer, List<Student>> map = students.stream().map(el -> {
//            el.setName(el.getName().toUpperCase());
//            return el;
//        }).collect(Collectors.groupingBy(el->el.getCourse()));
//
//        for(Map.Entry<Integer, List<Student>> entry: map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
//        }

        Map<Boolean, List<Student>> map = students.stream().map(el -> {
            el.setName(el.getName().toUpperCase());
            return el;
        }).collect(Collectors.partitioningBy(el -> el.getAvgGrade() > 7));

        for (Map.Entry<Boolean, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }

    }
}
