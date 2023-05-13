package com.example.from_zero_to_hero.collections;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Za", 442123);
        Employee emp2 = new Employee(21, "Zan", 242);
        Employee emp3 = new Employee(15, "Zag", 654);
        Employee emp4 = new Employee(631, "Zaf", 7654);
        Employee emp5 = new Employee(641, "Zar", 2341);
        Employee emp6 = new Employee(61, "Zai", 5486);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);
        Collections.sort(employees);
        int index = Collections.binarySearch(employees,
                new Employee(631, "Zaf", 7654));

        System.out.println(index);
    }
}

class Employee implements Comparable<Employee>{
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {
        int result = this.id - anotherEmp.id;
        if (result == 0) {
            result = this.name.compareTo(anotherEmp.name);
        }
        return result;
    }
}
