package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String file1 = in.readLine();
        String file2 = in.readLine();
        in.close();
        try (Reader reader = new FileReader(file1);
             Writer writer = new FileWriter(file2)) {
            BufferedReader br = new BufferedReader(reader);
            BufferedWriter bw = new BufferedWriter(writer);

            while (br.ready()) {
                String string = br.readLine();
                String data = "";
                Pattern p = Pattern.compile("\\b\\d+\\b");
                Matcher m = p.matcher(string);
                while (m.find()) {
                    data = m.group();
                    bw.write(data + " ");
                }
            }
            br.close();
            bw.close();
        }
    }
}
