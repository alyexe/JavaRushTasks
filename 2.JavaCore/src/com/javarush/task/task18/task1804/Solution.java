package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] bytes = new int[256];
        List<Integer> minCounts = new LinkedList<>();
        int min = Integer.MAX_VALUE;
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
                min = Math.min(min, bytes[i]);
            }
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == min) {
                minCounts.add(i);
            }
        }
        for (int i : minCounts) {
            System.out.print(i + " ");
        }
    }
}
