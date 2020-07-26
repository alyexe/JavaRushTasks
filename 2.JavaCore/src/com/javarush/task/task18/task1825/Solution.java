package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        String mainName = "", extension = "";
        int partNumber = 0;
        SortedMap<Integer, String> filenames = new TreeMap<>();
        String[] file = new String[3];
        byte[] buffer = new byte[8192];
        int size = 0;
        while (!filename.equalsIgnoreCase("end")) {
            file = filename.split("[.]");
            mainName = file[0];
            extension = file[1];
            partNumber = Integer.parseInt(file[2].split("part")[1]);
            filenames.put(partNumber, filename);
            filename = in.nextLine();
        }
        for (int p : filenames.keySet()) {
            try (
                    InputStream is = new BufferedInputStream(new FileInputStream(filenames.get(p)), 8192);
                    OutputStream os = new BufferedOutputStream(new FileOutputStream(mainName + "." + extension, true), 8192)
            ) {
                    size = is.read(buffer);
                    os.write(buffer, 0, size);
            } catch (IOException e) {
            }
        }
    }
}