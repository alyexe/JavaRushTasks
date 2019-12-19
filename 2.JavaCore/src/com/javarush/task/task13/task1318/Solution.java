package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner in = new Scanner(System.in);
        String fileName = in.next();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
        in.close();
        fileInputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
    }
}