package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int min = Integer.MAX_VALUE;
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            int data = fis.read();
            min = Math.min(min, data);
        }
        fis.close();
        System.out.println(min);
    }
}
