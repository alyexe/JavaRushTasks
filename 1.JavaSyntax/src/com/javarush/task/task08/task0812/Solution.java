package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int count = 0, t = 1;
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(r.readLine()));
        }
        for (int i = 1; i < list.size() ; i++) {
            t = list.get(i).equals(list.get(i-1))? t+1 : 1;
            count = t > count ? t : count;
        }
        System.out.println(count);
    }
}