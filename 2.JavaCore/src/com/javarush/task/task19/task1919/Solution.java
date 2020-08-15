package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String name;
        double value;
        double oldValue;
        TreeMap<String, Double> result = new TreeMap<>();
        try (
                BufferedReader file = new BufferedReader(new FileReader(args[0]));
        ) {
            while (file.ready()) {
                Pattern pattern = Pattern.compile("(.+)\\s(.+)");
                Matcher matcher = pattern.matcher(file.readLine());
                if (matcher.find()) {
                    name = matcher.group(1);
                    oldValue = result.get(name) == null ? 0 : result.get(name);
                    value = Double.parseDouble(matcher.group(2));
                    result.put(name, oldValue + value);
                }
            }
        } catch (IOException e) {}
        for ( String s: result.keySet()) {
            System.out.println(s + " " + result.get(s));
        }
    }
}
