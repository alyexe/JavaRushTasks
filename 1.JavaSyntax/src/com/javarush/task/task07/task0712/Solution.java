package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = 0, iMin = 0, iMax = 0;
        String str;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            str = r.readLine();
            list.add(str);
            if (min>str.length()){
                iMin=i;
                min = str.length();
            }
            if (max<str.length()){
                iMax=i;
                max=str.length();
            }
        }
        System.out.println(list.get(iMin<iMax?iMin:iMax));

    }
}
