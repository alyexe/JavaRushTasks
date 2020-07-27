package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String string = fileScanner.nextLine();
            String[] person = string.split(" ");
            String lastName = person[0];
            String firstName = person[1];
            String middleName = person[2];
            String day = person[3];
            String month = person[4];
            String year = person[5];
            Date birthdate = new Date(Integer.parseInt(year) - 1900, Integer.parseInt(month) - 1, Integer.parseInt(day));
            return new Person(firstName, middleName, lastName, birthdate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
