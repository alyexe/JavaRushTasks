package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private final FileWriter fileWriter;

    public static void main(String[] args) throws IOException{
        FileConsoleWriter fcw = new FileConsoleWriter("2");
        fcw.write(65);
        fcw.write("String");
        char[] chars = {'a', 's', 'd', 'f', 'g'};
        fcw.write(chars);
        fcw.write("String2", 2, 2);
        fcw.write(chars, 2, 3);
        fcw.close();
    }

    public FileConsoleWriter(String filename) throws IOException {
        this.fileWriter = new FileWriter(filename);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(String filename, boolean append) throws IOException {
        this.fileWriter = new FileWriter(filename, append);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
    }
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(Character.toChars(c));
    }
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off + len));
//        for (int i = off; i < len; i++) {
//            char[] c = Character.toChars(str.getBytes()[i]);
//            System.out.print(c);
//        }
    }
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.print(cbuf);
//        for (char c : cbuf) {
//            System.out.print(c);
//        }
    }
    public void close() throws IOException {
        fileWriter.close();
    }

}
