package com.example.from_zero_to_hero.stream;

import java.util.ArrayList;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Kit", 'f', 52, 4, 5.3);
        Student student3 = new Student("Hello", 'm', 12, 1, 3.3);
        Student student4 = new Student("Ketto", 'f', 44, 2, 9.3);

        Faculty f1 = new Faculty("Economics");
        Faculty f2 = new Faculty("Mathematics");
        f1.addStudentToFaculty(student3);
        f1.addStudentToFaculty(student4);
        f2.addStudentToFaculty(student1);
        f2.addStudentToFaculty(student2);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);

        facultyList.stream().flatMap(faculty -> {
            System.out.println(faculty.name);
            return faculty.getStudentList().stream();
        }).forEach(System.out::println);
//        facultyList.stream().flatMap(faculty -> faculty.getStudentList().stream()).forEach(e -> System.out.println(e));
    }
}

class Faculty {
    String name;
    List<Student> studentList;

    public Faculty(String name) {
        this.name = name;
        studentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudentToFaculty(Student student) {
        studentList.add(student);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}