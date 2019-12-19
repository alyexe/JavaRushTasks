package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            a = Integer.parseInt(r.readLine());
            if (a > 0) count++;
        }
        System.out.println(count);

    }
}
