package com.example.from_zero_to_hero.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentInfo {

    void testStudents(ArrayList<Student> students, StudentChecks studentChecks) {
        for (Student s : students) {
            if (studentChecks.check(s)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student student2 = new Student("Kit", 'f', 52, 4, 5.3);
        Student student3 = new Student("Hello", 'm', 12, 1, 3.3);
        Student student4 = new Student("Ketto", 'f', 44, 2, 9.3);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        StudentInfo info = new StudentInfo();
        // not good example
        info.testStudents(students, new CheckOverGrade());
        // with anonymous class
        info.testStudents(students, new StudentChecks() {
            @Override
            public boolean check(Student s) {
                return s.age < 30;
            }
        });
        // with lambda
        info.testStudents(students, (Student student) -> {return student.age < 20;});
        // более короткий вариант
        info.testStudents(students, student -> student.age < 20);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.course - o2.course;
            }
        });

        Collections.sort(students, (stud1, stud2) -> stud1.course - stud2.course);

        StudentChecks sc = (Student student) -> {return student.age < 20;};
    }

    void printStudentOverGrade(ArrayList<Student> all, double grade) {
        for (Student s : all) {
            if (s.avgGrade > grade) {
                System.out.println(s);
            }
        }
    }

    void printStudentUnderAge(ArrayList<Student> all, int age) {
        for (Student s : all) {
            if (s.age < age) {
                System.out.println(s);
            }
        }
    }

}
// функциональный интерфейс, только 1 метод допустим
interface StudentChecks {
    boolean check(Student s);
}

class CheckOverGrade implements StudentChecks {

    @Override
    public boolean check(Student s) {
        return s.avgGrade > 8;
    }
}
