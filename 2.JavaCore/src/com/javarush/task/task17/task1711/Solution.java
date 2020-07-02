package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    createPerson(args);
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    updatePerson(args);
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    deletePerson(args);
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    infoPerson(args);
                    break;
                }
        }
    }

    private static void infoPerson(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            System.out.print(person.getName() + " ");
            System.out.print(getParsedSex(person.getSex()) + " ");
            System.out.println(getDate(person.getBirthDate()));
        }
    }

    private static void deletePerson(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }

    private static void updatePerson(String[] args) {
        Person person;
        for (int i = 1; i < args.length; i += 4) {
            person = allPeople.get(Integer.parseInt(args[i]));
            person.setName(args[i+1]);
            person.setSex(setParsedSex(args[i+2]));
            person.setBirthDate(setDate(args[i+3]));
        }
    }

    private static void createPerson(String[] args) {
        for (int i = 1; i < args.length; i += 3) {
            if (args[i+1].equals("м")) {
                allPeople.add(Person.createMale(args[i], setDate(args[i+2])));
            } else
                if (args[i+1].equals("ж")) {
                    allPeople.add(Person.createFemale(args[i], setDate(args[i+2])));
                }
            System.out.println(allPeople.size() - 1);
        }
    }

    private static Date setDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    private static String getDate(Date date) {
        return new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(date);
    }

    private static Sex setParsedSex(String sex) {
        if (sex.equals("м")) return Sex.MALE;
        if (sex.equals("ж")) return Sex.FEMALE;
        return null;
    }

    private static String getParsedSex(Sex sex) {
        if (sex == Sex.MALE) return "м";
        if (sex == Sex.FEMALE) return "ж";
        return null;
    }
}
