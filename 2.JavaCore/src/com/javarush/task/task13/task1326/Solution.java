package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        int i;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String fileName = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(fileInputStream);
        BufferedReader reader = new BufferedReader(streamReader);
        while(reader.ready()){
            i = Integer.parseInt(reader.readLine());
            if(i%2 == 0) arrayList.add(i);
        }
        Collections.sort(arrayList);
        for (Integer a: arrayList) {
            System.out.println(a);
        }
    }
}
