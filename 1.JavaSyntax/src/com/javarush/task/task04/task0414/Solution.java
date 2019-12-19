package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(read.readLine());
        if (y%4 > 0 || (y%100 == 0 & y%400 > 0)) {
            System.out.println("количество дней в году: 365");
        }
        else System.out.println("количество дней в году: 366");
    }
}