package com.example.from_zero_to_hero.comparation;

import java.util.*;

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
        Collections.sort(list, new SalaryComparator());
        System.out.println(list);
    }
}

class Employee
//        implements Comparable<Employee>
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

    /*@Override
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
    }*/
}

class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        if (emp1.id == emp2.id) {
            return 0;
        } else if (emp1.id < emp2.id) {
            return -1;
        } else {
            return 1;
        }
    }
}

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp1.name);
    }
}

class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.salaty - emp2.salaty;
    }
}
