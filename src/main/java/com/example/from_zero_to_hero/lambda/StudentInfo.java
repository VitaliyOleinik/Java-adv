package com.example.from_zero_to_hero.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class StudentInfo {

    void testStudents(ArrayList<Student> students, Predicate<Student> predicate) {
        for (Student s : students) {
            if (predicate.test(s)) {
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
//        info.testStudents(students, new CheckOverGrade());
        // with anonymous class
//        info.testStudents(students, new StudentChecks() {
//            @Override
//            public boolean check(Student s) {
//                return s.age < 30;
//            }
//        });
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

        // Predicate
        Predicate<Student> p1 = (Student student) -> student.age < 20;
        Predicate<Student> p2 = (Student student) -> student.sex == 'm';

        info.testStudents(students, p1.and(p2));

        double res1 = avgOfSmth(students, student -> student.avgGrade);
        System.out.println("---------------------------------------");
        System.out.println("Average of grades: " + res1);
        double res2 = avgOfSmth(students, student -> (double) student.course);
        System.out.println("Average of course: " + res2);
        System.out.println("---------------------------------------");
    }

    // Пример с Function
    Function<Student, Double> function = student -> student.avgGrade;

    private static double avgOfSmth(List<Student> students, Function<Student, Double> function) {
        double result = 0;
        for (Student s: students) {
            result += function.apply(s);
        }
        result = result / students.size();
        return result;
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
