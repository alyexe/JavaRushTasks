package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader file1 = new BufferedReader (new FileReader(args[0]));
                BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]))
        ) {
            while (file1.ready()) {
                Pattern pattern = Pattern.compile("(\\S*\\d\\S*)");
                Matcher matcher = pattern.matcher(file1.readLine());
                while (matcher.find()) {
                    file2.write(matcher.group() + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
