package com.javarush.task.task17.task1721;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        try {
            allLines = Files.readAllLines(Paths.get(fileName1));
            forRemoveLines = Files.readAllLines(Paths.get(fileName2));
        } catch (IOException e) {
            System.out.println("Error reading files");
        }

        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
        }
    }

    public void joinData() throws CorruptedDataException {
        if (!allLines.containsAll(forRemoveLines)) {
            allLines.clear();
            throw new CorruptedDataException();
        } else {
            for (String s : forRemoveLines) {
                allLines.remove(s);
            }
        }
    }
}
