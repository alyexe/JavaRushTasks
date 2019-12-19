package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        String methodName, className;
            methodName = element[2].getMethodName();
            className = element[2].getClassName();
            System.out.println(className + ": " + methodName + ": " + s);
    }
}
