package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String name;
        int day;
        int month;
        int year;

        Pattern pattern = Pattern.compile("(\\D+)\\s(\\d+)\\s(\\d+)\\s(\\d+)");

        try (
                BufferedReader file = new BufferedReader(new FileReader(args[0]))
        ) {
            while (file.ready()) {
                Matcher matcher = pattern.matcher(file.readLine());
                while (matcher.find()) {
                    name = matcher.group(1);
                    day = Integer.parseInt(matcher.group(2).trim());
                    month = Integer.parseInt(matcher.group(3).trim());
                    year = Integer.parseInt(matcher.group(4).trim());
                    Date date = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH).parse(day + " " + month + " " + year);
                    Person person = new Person(name, date);
                    PEOPLE.add(person);
                }
            }
        } catch (Exception e) {
        }
    }
}
