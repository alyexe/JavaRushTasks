package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {

        System.out.println(new Solution(4));
        try (
                OutputStream os = new FileOutputStream("1");
                InputStream is = new FileInputStream("1");
                ObjectOutputStream oos = new ObjectOutputStream(os);
                ObjectInputStream ois = new ObjectInputStream(is)
        ) {
            Solution savedObject = new Solution(10);
            System.out.println(savedObject);
            oos.writeObject(savedObject);
            oos.flush();

            Solution loadedObject;
            loadedObject = (Solution) ois.readObject();
            System.out.println(loadedObject);

            System.out.println(loadedObject.string.equals(savedObject.string));
        } catch (Exception e) {
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
