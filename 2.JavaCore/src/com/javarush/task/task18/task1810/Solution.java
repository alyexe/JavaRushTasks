package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        while (true) {
            Scanner in = new Scanner(System.in);
            String file = in.nextLine();
            FileInputStream fis = new FileInputStream(file);
            if (fis.available() < 1000) {
                fis.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {
    }
}
