package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        int data;
        int spaces = 0;
        int allSymbols = 0;
        String filename = args[0];
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while (br.ready()) {
            data = br.read();
            if (data == 0x20) {
                spaces++;
            }
            allSymbols++;
        }
        br.close();
        System.out.print(new DecimalFormat("#0.00").format((double) spaces * 100 / allSymbols).replace(',', '.'));    }
}
