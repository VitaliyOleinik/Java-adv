package com.example.from_zero_to_hero.generics.game;

public class Employee extends Participant{
    private String title;
    private int salary;
    public Employee(String name, int age) {
        super(name, age);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
