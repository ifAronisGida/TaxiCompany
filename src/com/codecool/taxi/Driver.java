package com.codecool.taxi;

import java.util.ArrayList;
import java.util.Random;

public class Driver {

    private int phoneNumber;
    private String name;
    private int age;
    private int salary;
    private Experience experience;
    private static ArrayList<Integer> phoneBook = new ArrayList<>();
    private static int counter = 0;

    public Driver() {
        phoneNumber = 11110 + ++counter;
        phoneBook.add(phoneNumber);
        experience = getRandomExperience();
        name = "Driver" + ++counter;
        age = 20 + ++counter;
        salary = 140;
    }

    public Experience getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }

    public enum  Experience {
        BEGINNER,
        ADVANCED,
        PROFESSIONAL
    }

    private Experience getRandomExperience() {
       Experience experience;
       Random random = new Random();
       int randomInt = random.nextInt(3);
       switch (randomInt) {
           case 0:
               experience = Experience.BEGINNER;
               break;
           case 1:
               experience = Experience.ADVANCED;
               break;
           case 2:
               experience = Experience.PROFESSIONAL;
               break;
           default:
               experience = Experience.BEGINNER;
               break;
       }
       return experience;
    }
}
