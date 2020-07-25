package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) {
        int[] bytes = new int[256];
        try (InputStream fis = new FileInputStream(args[0])) {
            while (fis.available() > 0) {
                int data = fis.read();
                bytes[data]++;
            }
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > 0)
                    System.out.println((char) i + " " + bytes[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
