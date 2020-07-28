package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream system = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        System.setOut(system);

        String result = outputStream.toString();
        Pattern pattern = Pattern.compile("(\\d+)\\s(\\D)\\s(\\d+)");
        Matcher matcher = pattern.matcher(result);
        matcher.find();
        int a = Integer.parseInt(matcher.group(1));
        int b = Integer.parseInt(matcher.group(3));
        int c = 0;
        String op = matcher.group(2);
        if (op.equalsIgnoreCase("+")) c = a + b;
        if (op.equalsIgnoreCase("-")) c = a - b;
        if (op.equalsIgnoreCase("*")) c = a * b;

        System.out.println(result + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

