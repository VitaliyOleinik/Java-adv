package com.example.from_zero_to_hero.stream;

import com.example.from_zero_to_hero.generics.game.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticalExercisesHelpYouMasterJavaStreamAPI {
    public Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getTitle));
    }

    public double calculateAverage(List<Employee> employeeList) {
        return employeeList.stream()
                .mapToInt(Employee::getSalary)
                .average()
                .getAsDouble();
    }
}
