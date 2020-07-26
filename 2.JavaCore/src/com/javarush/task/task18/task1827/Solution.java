package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String file = in.nextLine();
        String productName = "";
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("-c")) {
                for (int i = 1; i < args.length - 2; i++) {
                    productName = productName + args[i] + " ";
                }
                double price = Double.parseDouble(args[args.length - 2]);
                int quantity = Integer.parseInt(args[args.length - 1]);
                if (productName.length() > 30) productName = productName.substring(0, 30);
                int maxId = 0;

                try (
                        BufferedReader reader = new BufferedReader(new FileReader(file))
                ) {
                    while (reader.ready()) {
                        String id = reader.readLine().substring(0, 8).trim();
                        maxId = Math.max(maxId, Integer.parseInt(id));
                    }
                } catch (IOException e) {}

                String result = String.format("\n%-8d%-30s%-8.2f%-4d", maxId + 1, productName, price, quantity);
                System.out.println(result);
                System.out.println(productName);
                System.out.println(price);
                System.out.println(quantity);

                try (
                        Writer writer = new BufferedWriter(new FileWriter(file, true))
                ) {
                    writer.write(result);
                } catch (IOException e) {
                }
            }
        }
    }
}
