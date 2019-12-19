package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] day = {"понедельник","вторник","среда","четверг","пятница","суббота","воскресенье"};
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(read.readLine());
        if (a > 0 & a < 8){
            System.out.println(day[a-1]);
        } else System.out.println("такого дня недели не существует");
    }
}