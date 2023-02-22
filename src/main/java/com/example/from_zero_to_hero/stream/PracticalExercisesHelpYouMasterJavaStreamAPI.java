package com.example.from_zero_to_hero.stream;

import com.example.from_zero_to_hero.generics.game.Employee;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Path.of(""), StandardCharsets.UTF_8);

        Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println("listOfAllIntegers = " + listOfAllIntegers);


        String[][] dataArray = new String[][]{{"a", "b"},
                {"c", "d"}, {"e", "f"}, {"g", "h"}};

        List<String> listOfAllChars = Arrays.stream(dataArray)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println("listOfAllChars = " + listOfAllChars);


    }
}
