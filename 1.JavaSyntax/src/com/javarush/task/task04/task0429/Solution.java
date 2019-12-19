package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int a;
        int pos=0;
        int neg=0;
        for (int i=0;i<3;i++){
            a=Integer.parseInt(r.readLine());
            if (a>0) pos++;
            if (a<0) neg++;
        }
        System.out.println("количество отрицательных чисел: "+neg);
        System.out.println("количество положительных чисел: "+pos);

    }
}
