package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(read.readLine());
        int b = Integer.parseInt(read.readLine());
        int c = Integer.parseInt(read.readLine());
        if (a<(b+c) & b<(a+c) & c<(a+b)) {
            System.out.println("Треугольник существует.");
        }
        else System.out.println("Треугольник не существует.");
    }
}