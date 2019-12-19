package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int i;
        ArrayList<String> list = new ArrayList<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i < 10; i++) { //заносим в список строки
            list.add(r.readLine());
        }
        for (i = 1; i < 10; i++) { //считываем строки из списка
            if (list.get(i).length() < list.get(i-1).length()){ //если строка короче предыдущей
                System.out.println(i); //выводим индекс этой строки
                break; //и заканчиваем программу
            }
        }
    }
}

