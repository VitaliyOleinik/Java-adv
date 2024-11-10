package com.example.from_zero_to_hero.annotation_examples;

import java.lang.annotation.*;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class xiaomiClass = Class.forName("com.example.from_zero_to_hero.annotation_examples.Xiaomi");
        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sp = (SmartPhone) annotation1;
        System.out.println("Annotation info from Xiaomi class " + sp.OS() + " year " + sp.yearOfCompanyCreation());

        Class iphoneClass = Class.forName("com.example.from_zero_to_hero.annotation_examples.Iphone");
        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sp2 = (SmartPhone) annotation2;
        System.out.println("Annotation info from Iphone class " + sp2.OS() + " year " + sp2.yearOfCompanyCreation());
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    String OS() default "Android";

    int yearOfCompanyCreation() default 2010;
}

@SmartPhone(/*OS = "Android", yearOfCompanyCreation = 2010*/)
class Xiaomi {
    String model;
    double price;
}

@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class Iphone {
    String model;
    double price;
}
