package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        try (
                Reader reader = new InputStreamReader(new FileInputStream(file1));
                Writer writer = new OutputStreamWriter(new FileOutputStream(file2));
                BufferedReader br = new BufferedReader(reader);
                BufferedWriter bw = new BufferedWriter(writer);
        ) {
            while (br.ready()) {
                stringList.add(br.readLine());
            }
            for (String s : stringList) {
                String[] strings = s.split("\\s");
                for (String s2 : strings) {
                    float f = Float.parseFloat(s2);
                    integerList.add(Math.round(f));
                }
            }
            for (Integer i : integerList) {
                bw.write(i + " ");
            }
        } catch (IOException e) {
        }
    }
}
