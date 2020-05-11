package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.util.Scanner;

public class Solution {
    public static CanFly result;

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static void main(String[] args) {

    }

    public static void reset() {
        //add your code here - добавьте код тут
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.equals("helicopter")) {
            result = new Helicopter();
        } else if (s.equals("plane")) {
            try {
                int passengers = Integer.parseInt(scanner.nextLine());
                result = new Plane(passengers);
            } catch (Exception e) {
            }
        }
        scanner.close();
    }
}
