package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int data;
        int count = 0;
        String filename = args[0];
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while (br.ready()) {
            data = br.read();
            if ((data > 64 && data < 91) || (data > 96 && data < 123)) {
                count++;
            }
        }
        br.close();
        System.out.println(count);
    }
}
