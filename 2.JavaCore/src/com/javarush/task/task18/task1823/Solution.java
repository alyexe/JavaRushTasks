package com.javarush.task.task18.task1823;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        while (!filename.equalsIgnoreCase("exit")) {
            ReadThread thread = new ReadThread(filename);
            thread.start();
            filename = in.nextLine();
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            synchronized (this) {
                try (
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(this.getName()))
                ) {
                    int[] bytes = new int[256];
                    int data;
                    int max = 0;
                    while (bis.available() > 0) {
                        data = bis.read();
                        bytes[data]++;
                        max = Math.max(max, bytes[data]);
                    }
                    for (int i = 0; i < bytes.length; i++) {
                        if (max == bytes[i]) {
                            resultMap.put(this.getName(), i);
                        }
                    }
                } catch (IOException e) {
                }
            }
        }
    }
}
