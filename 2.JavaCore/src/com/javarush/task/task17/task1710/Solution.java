package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                createPerson(args[1], args[2], args[3]);
                break;
            case "-u":
                updatePerson(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                deletePerson(args[1]);
                break;
            case "-i":
                infoPerson(args[1]);
                break;
            default:
                System.out.println("Use -c -u -d -i");
        }
    }

    private static void infoPerson(String id) {
        int index = Integer.parseInt(id);
        Person person = allPeople.get(index);
        System.out.print(person.getName() + " ");
        System.out.print(getParsedSex(person.getSex()) + " ");
        System.out.println(getDate(person.getBirthDate()));
    }

    private static void deletePerson(String id) {
        int index = Integer.parseInt(id);
        Person person = allPeople.get(index);
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
    }

    private static void updatePerson(String id, String name, String sex, String birthday) {
        int index = Integer.parseInt(id);
        Person person = allPeople.get(index);
        person.setName(name);
        person.setSex(setParsedSex(sex));
        person.setBirthDate(setDate(birthday));

    }

    private static void createPerson(String name, String sex, String birthday) {
        createPerson(allPeople.size(), name, sex, birthday);
    }

    private static void createPerson(int id, String name, String sex, String birthday) {
        switch (sex) {
            case "м":
                allPeople.add(id, Person.createMale(name, setDate(birthday)));
                break;
            case "ж":
                allPeople.add(id, Person.createFemale(name, setDate(birthday)));
                break;
            default:
                System.out.println("Failed to create person");
        }
        System.out.println(id);
    }

    private static Date setDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    private static String getDate(Date date) {
        return new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(date);
    }

    private static String getParsedSex(Sex sex) {
        switch (sex) {
            case FEMALE:
                return "ж";
            case MALE:
                return "м";
            default:
                return null;
        }
    }

    private static Sex setParsedSex(String sex) {
        switch (sex) {
            case "ж":
                return Sex.FEMALE;
            case "м":
                return Sex.MALE;
            default:
                System.out.println("Error set sex");
                return null;
        }
    }

}
