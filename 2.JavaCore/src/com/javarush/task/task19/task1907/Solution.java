package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();
        in.close();
        try (Reader reader = new FileReader(filename)) {
            BufferedReader br = new BufferedReader(reader);
            while (br.ready()) {
                if (br.readLine().contains("world")) count++;
            }
            br.close();
        }
        System.out.println(count);
    }
}
