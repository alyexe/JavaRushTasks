package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int numbersToOut = 5;
        int[] array = new int[20];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int i = 0; i < numbersToOut; i++) {
            System.out.println(array[i]);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        int tmp;
        Boolean isExit = false;
        while (!isExit) {
            isExit = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i - 1]) {
                    tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                    isExit = false;
                }
            }
        }
    }
}
