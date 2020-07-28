package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String file1 = in.readLine();
        String file2 = in.readLine();
        in.close();
        try (BufferedReader reader = new BufferedReader(new FileReader(file1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
            while (reader.ready()) {
                String inputString = reader.readLine();
                String outputString = inputString.replace(".", "!");
                writer.write(outputString + "\n");
            }
        }
    }
}
