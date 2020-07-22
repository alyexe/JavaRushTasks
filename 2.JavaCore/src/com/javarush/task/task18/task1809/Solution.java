package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        if (fis.available() > 0) {
            int count = fis.available();
            byte[] buffer = new byte[count];
            count = fis.read(buffer);
            for (int i = count - 1; i >= 0; i--) {
                fos.write(buffer[i]);
            }
        }
        fis.close();
        fos.close();
    }
}
