package com.example.from_zero_to_hero.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
//        String s1 = "ABCD ABCE ABCFABCGABCH";
//        Pattern pattern1 = Pattern.compile("ABC");

//        String s1 = "OPABMNCD";
//        Pattern pattern1 = Pattern.compile("[ABC]"); // [] - одно значение

//        String s1 = "ABDOP";
//        Pattern pattern1 = Pattern.compile("AB[C-F]OP");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc[^e-g4-7]"); // ^ отрицание

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc(e|5)");

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc."); // . любой символ

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("^abc"); // начало строки

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("abc5abcg6abch$"); // конец строки

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\d"); // одна цифра

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\D"); // все без цифр

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w"); // [A-Za-z0-9_]

//        String s1 = "abcd abce abc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\w+"); // Position: 0   abcd
                                                    // Position: 5   abce
                                                    // Position: 10   abc5abcg6abch
//        String s1 = "abcd@#!#@ #$@ ab=====ce a124214@#!@$#(*&^%$^bc5abcg6abch";
//        Pattern pattern1 = Pattern.compile("\\W+"); // символ

//        String s1 = "poka abc Vitaliiy dom kino";
//       Pattern pattern1 = Pattern.compile("\\w{4}");
                                                        /*
                                                        Position: 0   poka
                                                        Position: 9   Vita
                                                        Position: 13   liiy
                                                        Position: 22   kino*/

        String s1 = "abcd abce abc5abcg6abch";
        Pattern pattern1 = Pattern.compile("\\d"); // одна цифра

        Matcher matcher = pattern1.matcher(s1);

        while (matcher.find()) {
            System.out.println("Position: " + matcher.start() + "   " + matcher.group());
        }
    }
}
