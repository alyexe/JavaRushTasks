package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new MyThread1());
        threads.add(new MyThread2());
        threads.add(new MyThread3());
        threads.add(new MyThread4());
        threads.add(new MyThread5());
    }

    public static void main(String[] args) {
    }

    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            while(true){}
        }
    }

    public static class MyThread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThread3 extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThread4 extends Thread implements Message {
        @Override
        public void run() {
            while(!isInterrupted()){}
        }

        @Override
        public void showWarning() {
            Thread.currentThread().interrupt();
        }
    }

    public static class MyThread5 extends Thread {
        private boolean isCancel = false;
        private String s;
        private int sum = 0;

        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                while(!isCancel) {
                    s = bufferedReader.readLine();
                    if(!(isCancel = s.equalsIgnoreCase("N"))) {
                        sum += Integer.parseInt(s);
                    }
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}