package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String fileName = in.readLine();
        in.close();

        String string;
        String[] result;
        int count;

        try (
                BufferedReader file = new BufferedReader(new FileReader(fileName))
        ) {
            while (file.ready()) {
                count = 0;
                string = file.readLine();
                result = string.split(" ");
                for (int i = 0; i < result.length; i++) {
                    for (String s : words) {
                        if (s.equals(result[i])) count++;
                    }
                }
                if (count == 2) System.out.println(string);
            }
        }
    }
}
