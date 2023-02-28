package com.example.from_zero_to_hero.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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

class Book {
    int id;
    String name;
    String author;

    public Book() {
    }

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class ConvertListToMap {
    List<Book> books = new ArrayList<>();

    Map<Integer, Book> result = books.stream()
            .collect(Collectors.toMap(book->book.id, book -> book));

    Map<Integer, Book> result1 = books.stream()
            .collect(Collectors.toMap(Book::getId, Function.identity()));



    public static void main(String[] args) {
        List cards = Arrays.asList("Visa", "MasterCard", "American Express", "Visa");

        Object cards2Length = cards.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println("list: " + cards);

        Map mapCards2Length = (Map) cards.stream()
                .collect(Collectors.toMap(Function.identity(),
                        String::length, (e1, e2) -> e1));

        System.out.println("map: " + mapCards2Length);

        List<String> hostingProviders = Arrays.asList("Bluehost", "GoDaddy",
                "Amazon AWS", "LiquidWeb", "FatCow");
        System.out.println("list: " + hostingProviders);

        Map<String, Integer> mapInitCards2Length = hostingProviders.stream()
                .collect(Collectors.toMap(Function.identity(),
                        String::length,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        System.out.println("map: " + mapInitCards2Length);
    }

}

class FlatMapExample3 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\test\\test.txt");

        // read file into a stream of lines
        Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);

        // stream of array...hard to process.
        // Stream<String[]> words = lines.map(line -> line.split(" +"));

        // stream of stream of string....hmm...better flat to one level.
        // Stream<Stream<String>> words = lines.map(line -> Stream.of(line.split(" +")));

        // result a stream of words, good!
        Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));

        // count the number of words.
        long noOfWords = words.count();

        System.out.println(noOfWords);  // 16
    }
}

class FlatMapExample4 {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};

        //Stream<int[]>
        Stream<int[]> streamArray = Stream.of(array);

        //Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

        intStream.forEach(x -> System.out.println(x));

    }

    private void exampleLongStream() {
        long[] array = {1, 2, 3, 4, 5, 6};

        Stream<long[]> longArray = Stream.of(array);

        LongStream longStream = longArray.flatMapToLong(x -> Arrays.stream(x));

        System.out.println(longStream.count());
    }
}

class Human {
    private final String name;
    private final List<String> pets;

    public Human(String name, List<String> pets) {
        this.name = name;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public List<String> getPets() {
        return pets;
    }
}

class ExampleFlatMap {
    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human("Sam", List.of("Buddy", "Lucy")),
                new Human("Bob", List.of("Frankie", "Rosie")),
                new Human("Marta", List.of("Simba", "Tilly")));

        List<String> petNames = humans.stream()
                .map(human -> human.getPets()) //преобразовываем Stream<Human> в Stream<List<Pet>>
                .flatMap(pets -> pets.stream())//"разворачиваем" Stream<List<Pet>> в Stream<Pet>
                .collect(Collectors.toList());

        System.out.println(petNames); // output [Buddy, Lucy, Frankie, Rosie, Simba, Tilly]
    }

    public static void streamFlatMap() {
        List<Human> humans = List.of(
                new Human("Sam", List.of("Buddy", "Lucy")),
                new Human("Bob", List.of("Frankie", "Rosie")),
                new Human("Marta", List.of("Simba", "Tilly")));

        List<String> petNames = humans.stream()
                .flatMap(human -> human.getPets().stream())
                .collect(Collectors.toList());

        System.out.println(petNames); // output [Buddy, Lucy, Frankie, Rosie, Simba, Tilly]
    }
}
