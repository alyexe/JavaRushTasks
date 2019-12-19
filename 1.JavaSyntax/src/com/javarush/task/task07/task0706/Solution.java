package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] a=new int[15];
        int even=0, odd=0;
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < a.length; i++) {
            a[i]=Integer.parseInt(r.readLine());
            if (i%2==0) even+=a[i];
            else odd+=a[i];
        }
        String s=even>odd?"четными":"нечетными";
        System.out.println("В домах с "+s+" номерами проживает больше жителей.");
    }
}
