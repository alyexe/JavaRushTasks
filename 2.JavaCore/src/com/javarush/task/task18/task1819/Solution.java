package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();

        try (
                InputStream bis1 = new BufferedInputStream(new FileInputStream(file1));
                InputStream bis2 = new BufferedInputStream(new FileInputStream(file2));
        ) {
            byte[] buffer = new byte[8192];
            byte[] temp = new byte[bis1.available()];
            int tempSize = 0;

            while (bis1.available() > 0) {
                tempSize = bis1.read(temp);
            }

            OutputStream bos = new BufferedOutputStream(new FileOutputStream(file1));
            while (bis2.available() > 0) {
                int size = bis2.read(buffer);
                bos.write(buffer, 0, size);
            }

            bos.write(temp, 0, tempSize);
            bos.close();
        } catch (IOException e) {
        }
    }
}
