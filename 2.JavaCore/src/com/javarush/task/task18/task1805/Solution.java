package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] bytes = new int[256];
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            int data = fis.read();
            bytes[data]++;
        }
        fis.close();

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
