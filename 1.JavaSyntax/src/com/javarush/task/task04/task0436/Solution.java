package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int m=Integer.parseInt(r.readLine());
        int n=Integer.parseInt(r.readLine());
        int i,j;
        for (i=m;i>0;i--){
            for(j=n;j>0;j--){
                System.out.print(8);
            }
            System.out.println("");
        }

    }
}
