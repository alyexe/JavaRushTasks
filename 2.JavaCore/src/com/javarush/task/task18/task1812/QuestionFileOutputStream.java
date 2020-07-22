package com.javarush.task.task18.task1812;

/* 
Расширяем AmigoOutputStream
*/

import java.io.IOException;
import java.util.Scanner;

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream stream;

    public QuestionFileOutputStream(AmigoOutputStream stream) {
        this.stream = stream;
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        Scanner in = new Scanner(System.in);
        String answer;
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        answer = in.nextLine();
        if (answer.equals("Д")) {
            stream.close();
        }
    }
}

