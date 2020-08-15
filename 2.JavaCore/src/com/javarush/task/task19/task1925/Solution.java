package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("\\S{7,}");
        try (
                BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
                BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]))
        ) {
            while (file1.ready()) {
                Matcher matcher = pattern.matcher(file1.readLine());
                while (matcher.find()) {
                    result.append(matcher.group() + ",");
                }
            }
            file2.write(result.toString().replaceAll(",$", ""));
        } catch (IOException e) {
        }
    }
}
