package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/
public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();
    private static int triesCount = 0;
    private static int exceptionsCount = 0;

    public static void main(String[] args) {

        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }

        System.out.println("========================");
        System.out.println("Tries: " + triesCount);
        System.out.println("Exceptions: " + exceptionsCount);

    }

    private static void initExceptions() {   //the first exception

        try {
            triesCount++;
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        //напишите тут ваш код
        try {
            triesCount++;
            int[] arr = {1, 2};
            arr[0] = arr[2];
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        try {
            triesCount++;
            String s = "a";
            s.charAt(2);
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        try {
            triesCount++;
            int i = Integer.parseInt("a");
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        try {
            triesCount++;
            Object o = "a";
            Integer i = (Integer) o;
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        try {
            triesCount++;
            String s = null;
            s.getBytes();
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        try {
            triesCount++;
            File file = new File("");
            InputStreamReader in = new FileReader(file);
            in.read();
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        try {
            triesCount++;
            Integer[] a = new Integer[-1];
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        try {
            triesCount++;
            throw new IOException();
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }

        try {
            triesCount++;
            throw new Exception();
        } catch (Exception e) {
            exceptions.add(e);
            exceptionsCount++;
        }
    }
}
