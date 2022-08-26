package com.example.from_zero_to_hero.comparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        Employee empl1 = new Employee(100, "Zaur", "Tregulov", 1234);
        Employee empl2 = new Employee(15, "Ivan", "Ipdsfdf", 4563);
        Employee empl3 = new Employee(1, "Vello", "Privet", 12);
//        Arrays.sort(new Employee[] {empl1, empl2, empl3}); throw Exception
        list.add(empl1);
        list.add(empl2);
        list.add(empl3);
        Collections.sort(list);
        System.out.println(list);
    }
}

class Employee
        implements Comparable<Employee>
{
    int id;
    String name;
    String surname;
    int salaty;

    public Employee(int id, String name, String surname, int salaty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salaty = salaty;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salaty=" + salaty +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {
//        if (this.id == anotherEmp.id) {
//            return 0;
//        } else if (this.id < anotherEmp.id) {
//            return -1;
//        } else {
//            return 1;
//        }

//        return this.id - anotherEmp.id;

        int res = this.name.compareTo(anotherEmp.name);
        if (res == 0) {
            res = this.surname.compareTo(anotherEmp.surname);
        }
        return res;
    }
}
