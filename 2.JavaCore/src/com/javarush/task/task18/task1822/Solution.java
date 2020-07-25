package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int id = Integer.parseInt(args[0]);
        Scanner in = new Scanner(System.in);
        String file = in.nextLine();
        List<String> stringList = new ArrayList<>();
        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
                BufferedReader br = new BufferedReader(isr);
        ) {
            while (br.ready()) {
                stringList.add(br.readLine());
            }
            for (String s : stringList) {
                int number = Integer.parseInt(s.split("\\s")[0]);
                if (number == id) {
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
        }
    }
}
