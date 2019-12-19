package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(r.readLine());
        String razr, odd;
        if (a>0&&a<1000) {
            if (a / 100 > 0) razr = "трехзначное";
            else if (a / 10 > 0) razr = "двузначное";
            else razr = "однозначное";
            if (a % 2 == 0) odd = "четное";
            else odd = "нечетное";
            System.out.println(odd + " " + razr + " число");
        }
    }
}
