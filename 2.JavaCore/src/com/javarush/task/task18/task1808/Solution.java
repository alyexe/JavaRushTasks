package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        String file3 = in.nextLine();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos2 = new FileOutputStream(file2);
        FileOutputStream fos3 = new FileOutputStream(file3);
        if (fis.available() > 0) {
        int count = fis.available();
        byte[] buffer = new byte[count];
            count = fis.read(buffer);
            if (count % 2 == 1) {
                fos2.write(buffer, 0, count / 2 + 1);
                fos3.write(buffer, count / 2 + 1, count / 2);
            } else {
                fos2.write(buffer, 0, count / 2);
                fos3.write(buffer, count / 2, count / 2);
            }
        }
        fis.close();
        fos2.close();
        fos3.close();
    }
}
