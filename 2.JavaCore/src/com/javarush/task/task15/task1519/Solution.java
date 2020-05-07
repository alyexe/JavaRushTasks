package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result;
        double d;
        short s;
        while(!(result = br.readLine()).contentEquals("exit")) {
            try {
                s = Short.parseShort(result);
                if(s < 0 || s > 127) print((int)s);
                else print((int)s);
            } catch(Exception e1) {
                try {
                    d = Double.parseDouble(result);
                    print(d);
                } catch (Exception e2) {
                    print(result);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
