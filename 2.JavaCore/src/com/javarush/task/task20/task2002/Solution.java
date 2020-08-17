package com.javarush.task.task20.task2002;

import javax.swing.text.DateFormatter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User newUser = new User();
            newUser.setFirstName("First Name");
            newUser.setLastName("Last Name");
            newUser.setBirthDate(new SimpleDateFormat("dd MM yyyy HH mm ss SSS", Locale.ENGLISH).parse("21 11 1992 12 05 21 321"));
            newUser.setCountry(User.Country.RUSSIA);
            newUser.setMale(true);
            javaRush.users.add(newUser);
            javaRush.users.add(newUser);
            javaRush.users.add(newUser);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User u : loadedObject.users) {
                System.out.println(u.getFirstName());
            }
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            for (User u : this.users) {
                writer.println(u.getFirstName());
                writer.println(u.getLastName());
                writer.println(u.getBirthDate() == null ? null : new SimpleDateFormat("dd MM yyyy HH mm ss SSS", Locale.ENGLISH).format(u.getBirthDate()));
                writer.println(u.getCountry());
                writer.println(u.isMale());
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User u = new User();
                String first = reader.readLine();
                u.setFirstName(first.equals("null") ? null : first);
                String last = reader.readLine();
                u.setLastName(last.equals("null") ? null : last);
                String date = reader.readLine();
                u.setBirthDate(date.equals("null") ? null : new SimpleDateFormat("dd MM yyyy HH mm ss SSS", Locale.ENGLISH).parse(date));
                String country = reader.readLine();
                u.setCountry(country.equals("null") ? null : User.Country.valueOf(country));
                String male = reader.readLine();
                u.setMale(male.equals("null") ? null : Boolean.valueOf(male));
                this.users.add(u);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
