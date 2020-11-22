package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution() {}

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "your.file.name";
        String obj = "1";

        Solution solution = new Solution(fileName);
        solution.writeObject("Test String");

        FileOutputStream fos = new FileOutputStream(obj);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(solution);

        FileInputStream fis = new FileInputStream(obj);
        ObjectInputStream ois = new ObjectInputStream(fis);

        solution = (Solution) ois.readObject();

        solution.writeObject("Another string");

        oos.writeObject(solution);

        solution.close();
        fos.close();
        oos.close();
        fis.close();
        ois.close();
    }
}
