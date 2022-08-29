package com.example.from_zero_to_hero.generics.game;

public class Test {
    public static void main(String[] args) {
        SchoolKid schoolKid1 = new SchoolKid("Ivan", 12);
        SchoolKid schoolKid2 = new SchoolKid("Liza", 9);

        Student student1 = new Student("Vit", 18);
        Student student2 = new Student("Zaur", 20);

        Employee employee1 = new Employee("Mikhail", 42);
        Employee employee2 = new Employee("Petr", 45);

        Team<SchoolKid> schoolKidTeam = new Team<>("Dragons");
        Team<Student> studentTeam = new Team<>("Go!");
        Team<Employee> employeeTeam = new Team<>("Super");
        schoolKidTeam.addNewParticipant(schoolKid1);
        schoolKidTeam.addNewParticipant(schoolKid2);

        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        Team<SchoolKid> schoolKidTeam2 = new Team<>("Mudrecy");
        SchoolKid schoolKid3 = new SchoolKid("Gena", 14);
        SchoolKid schoolKid4 = new SchoolKid("Cheburashka", 11);
        schoolKidTeam2.addNewParticipant(schoolKid3);
        schoolKidTeam2.addNewParticipant(schoolKid4);

        schoolKidTeam.playWith(schoolKidTeam2);
    }
}
