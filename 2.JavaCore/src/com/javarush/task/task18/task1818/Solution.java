package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file1 = in.nextLine();
        String file2 = in.nextLine();
        String file3 = in.nextLine();

        try (
                InputStream fis2 = new FileInputStream(file2);
                InputStream fis3 = new FileInputStream(file3);
                OutputStream fos = new FileOutputStream(file1);
                OutputStream fos2 = new FileOutputStream(file1, true);

                OutputStream bos = new BufferedOutputStream(fos);
                OutputStream bos2 = new BufferedOutputStream(fos2);
                InputStream bis2 = new BufferedInputStream(fis2);
                InputStream bis3 = new BufferedInputStream(fis3);
        ) {
            byte[] buffer = new byte[8192];

            while (fis2.available() > 0) {
                int size = bis2.read(buffer);
                bos.write(buffer, 0, size);
            }
            bos.flush();
            bos.close();
            fos.close();

            while (fis3.available() > 0) {
                int size = bis3.read(buffer);
                bos2.write(buffer,0, size);
            }
        } catch (IOException e) {
        }
    }
}
