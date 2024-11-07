package com.example.from_zero_to_hero.enums;

import java.util.Arrays;

public class Enum1 {
    public static void main(String[] args) {
//        Today today = new Today(WeekDays.MONDAY);
        for (WeekDays day : WeekDays.values()) {
            new Today(day).daysInfo();
        }

        WeekDays w1 = WeekDays.FRIDAY;
        WeekDays w2 = WeekDays.FRIDAY;
        WeekDays w3 = WeekDays.MONDAY;
        System.out.println(w1 == w2); // true
        System.out.println(w2 == w3); // false
        System.out.println(WeekDays.FRIDAY.equals(WeekDays2.FRIDAY)); // false
        WeekDays w4 = WeekDays.valueOf("MONDAY");
        System.out.println(w4);
        WeekDays[] array = WeekDays.values();
        System.out.println(Arrays.toString(array));
    }
}

enum WeekDays {
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY("good"),
    SATURDAY("great"),
    SUNDAY("great");

    private String mood;
    private WeekDays(String mood) {
        this.mood = mood;
    }
//    private WeekDays() {}
    public String getMood() {
        return mood;
    }
}

enum WeekDays2 {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

class Today {
    WeekDays weekDay;

    public Today(WeekDays weekDay) {
        this.weekDay = weekDay;
    }

    void daysInfo() {
        switch (weekDay) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("GO to work " + weekDay);
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Relax " + weekDay);
                break;
        }
        System.out.println("My mood is " + weekDay.getMood());
    }
}