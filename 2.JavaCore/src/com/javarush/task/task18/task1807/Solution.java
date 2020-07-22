package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int count = 0;
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            int data = fis.read();
            if (data == 44) count++;
        }
        fis.close();
        System.out.println(count);
    }
}
