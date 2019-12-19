package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int d=Integer.parseInt(r.readLine());
        if (d > 0){
            System.out.println(d*2);
        }
        else if (d<0){
            System.out.println(d+1);
        }
        else System.out.println(d);

    }

}