package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String filename = in.nextLine();
            try (InputStream is = new FileInputStream(filename)) {
            } catch (FileNotFoundException e) {
                System.out.println(filename);
                break;
            } catch (IOException e) {
                break;
            }
        }
    }
}
