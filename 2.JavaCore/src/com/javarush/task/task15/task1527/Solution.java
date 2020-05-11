package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
//        String input = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo&lvl=15&view";
        int contentStart = input.indexOf("?");
        String content = input.substring(contentStart + 1);
        String[] contentSplit = content.split("[&]+");
        List<String> contentValues = new ArrayList<>();
        List<String> contentKeys = new ArrayList<>();

        for (String s : contentSplit) {

            if(s.contains("obj")) {
                contentValues.add(s.substring(s.indexOf("=") + 1));
            }

            if(s.contains("=")) {
                contentKeys.add(s.substring(0, s.indexOf("=")));
            } else {
                contentKeys.add(s);
            }
        }

        for (String key : contentKeys) {
            System.out.print(key + " ");
        }

        System.out.println();

        for (String value : contentValues) {
            try {
                alert(Double.parseDouble(value));
            }
            catch (Exception e) {
                alert(value);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
