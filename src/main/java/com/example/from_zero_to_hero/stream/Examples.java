package com.example.from_zero_to_hero.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Examples {
    List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");

    long count = strList.stream().filter(String::isEmpty).count();
    long num = strList.stream().filter(x -> x.length() > 3).count();
    long count1 = strList.stream().filter(x -> x.startsWith("a")).count();

    List<String> countries = Arrays.asList("USA", "Japan", "France", "Germany");
    String upperCountries = countries.stream()
            .map(String::toUpperCase).collect(Collectors.joining(", "));

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 4);

    List<Integer> distinct = numbers.stream()
            .map(i -> i * i)
            .distinct()
            .collect(Collectors.toList());

    List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
    IntSummaryStatistics stats = primes.stream()
            .mapToInt((x) -> x)
            .summaryStatistics();
}

class FlatMap {
    public static void main(String[] args) {
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamPakistan);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);

        List<String> listOfAllPlayers = new ArrayList<>();

        for (List<String> team : playersInWorldCup2016) {
            for (String name : team) {
                listOfAllPlayers.add(name);
            }
        }

        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);

        List<String> flatMapList = playersInWorldCup2016
                .stream()
                .flatMap(pList -> pList.stream())
                .collect(Collectors.toList());

        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);
    }
}
