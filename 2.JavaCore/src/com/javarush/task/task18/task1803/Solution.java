package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] bytes = new int[255];
        List<Integer> maxCounts = new LinkedList<>();
        int max = 0;
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            int data = fis.read();
            max = Math.max(max, data);
            bytes[data]++;
        }
        fis.close();

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == max) {
                maxCounts.add(i);
            }
        }
        for (int i : maxCounts) {
            System.out.print(i + " ");
        }
    }
}
