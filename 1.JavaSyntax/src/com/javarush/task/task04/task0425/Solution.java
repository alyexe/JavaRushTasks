package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(r.readLine());
        int b=Integer.parseInt(r.readLine());
        int q;
        if (a>0&&b>0) q=1;
        else if (a<0&&b>0) q=2;
        else if (a<0&&b<0) q=3;
        else q=4;
        System.out.println(q);
    }
}
