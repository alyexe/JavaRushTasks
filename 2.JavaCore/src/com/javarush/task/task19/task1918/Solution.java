package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String file = in.readLine();
        in.close();
        String input = args[0];
        StringBuilder list = new StringBuilder();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(file));
        ) {
            while (reader.ready()) {
                String line = reader.readLine();
                list.append(line);
            }
        }

        Document doc = Jsoup.parse(list.toString(),"", Parser.xmlParser());
        Elements elements = doc.select(input);
        System.out.println(elements);
    }
}
