package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum=0, count=0;
        double sr=0;
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(r.readLine());
        while (a!=-1){
            sum+=a;
            count++;
            a=Integer.parseInt(r.readLine());
        }
        sr=1.0*sum/count;
        System.out.println(sr);
    }
}
