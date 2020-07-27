package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String file1 = in.readLine();
        String file2 = in.readLine();
        in.close();
        int count = 0;
        int data = 0;
        try (
                Reader reader = new FileReader(file1);
                Writer writer = new FileWriter(file2)
        ) {
            while (reader.ready()) {
                data = reader.read();
                if (count % 2 != 0) writer.write(data);
                count++;
            }
        } catch (IOException e) {
        }
    }
}
