package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        int n = 0;
        if (a!=b && b==c) System.out.println(1);
        if (b!=a && a==c) System.out.println(2);;
        if (c!=a && a==b) System.out.println(3);;

    }
}
