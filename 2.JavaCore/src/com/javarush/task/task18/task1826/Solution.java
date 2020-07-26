package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        byte[] buffer = new byte[8192];
        byte[] output;

        try (
                InputStream is = new BufferedInputStream(new FileInputStream(args[1]), 8192);
                OutputStream os = new BufferedOutputStream(new FileOutputStream(args[2]), 8192)
        ) {
            while (is.available() > 0) {
                int size = is.read(buffer);
                output = crypto(buffer);
                os.write(output, 0, size);
            }
        } catch (IOException e) {
        }

    }

    private static byte[] crypto(byte[] buffer) {
        byte[] result;
        ByteArrayInputStream arrayIn = new ByteArrayInputStream(buffer);
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        while (arrayIn.available() > 0) {
            int data = arrayIn.read();
            if (data < 128) {
                data += 128;
            } else if (data >= 128) {
                data -= 128;
            }
            arrayOut.write(data);
        }
        result = arrayOut.toByteArray();
        return result;
    }

}
