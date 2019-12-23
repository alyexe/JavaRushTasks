package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int nod = 1;
        int first = 1;
        int second = 1;
        int bigger, lower, d;

        Scanner in = new Scanner(System.in);

        try {
            first = in.nextInt();
            second = in.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        }

        bigger = Math.max(first, second);
        lower = Math.min(first, second);
        d = bigger % lower;

        if (d == 0) {
            nod = lower;
        } else {
            while (d != 0) {
                nod = d;
                d = lower % d;
            }
        }
        System.out.println(nod);
    }
}
