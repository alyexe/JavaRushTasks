package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String fileName = in.readLine();
        in.close();

        String string;

        try (
                BufferedReader file = new BufferedReader(new FileReader(fileName))
        ) {
            while (file.ready()) {
                string = file.readLine();
                char[] result;
                result = string.toCharArray();
                for (int i = result.length - 1; i >= 0; i--) {
                    System.out.print(result[i]);
                }
                System.out.println();
            }
        }
    }
}
