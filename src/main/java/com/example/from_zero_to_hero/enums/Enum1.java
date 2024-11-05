package com.example.from_zero_to_hero.enums;

public class Enum1 {
    public static void main(String[] args) {
//        Today today = new Today(WeekDays.MONDAY);
        for (WeekDays day : WeekDays.values()) {
            new Today(day).daysInfo();
        }
    }
}

enum WeekDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
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
    }
}