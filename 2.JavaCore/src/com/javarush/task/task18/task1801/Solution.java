package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int max = 0;
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            int data = fis.read();
            max = max > data ? max : data;
        }
        fis.close();
        System.out.println(max);
    }
}
