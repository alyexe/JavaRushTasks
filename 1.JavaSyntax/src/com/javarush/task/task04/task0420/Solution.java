package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(r.readLine());
        int b=Integer.parseInt(r.readLine());
        int c=Integer.parseInt(r.readLine());

        if (a>b){
            if (a>c) {
                if (b>c) System.out.println(a+" "+b+" "+c);
                else System.out.println(a+" "+c+" "+b);
            } else System.out.println(c+" "+a+" "+b);
        } else if (b>c) {
            if (a > c) System.out.println(b + " " + a + " " + c);
            else System.out.println(b + " " + c + " " + a);
        } else System.out.println(c+" "+b+" "+a);
    }
}
