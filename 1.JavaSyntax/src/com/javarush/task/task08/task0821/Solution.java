package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> people = new HashMap<>();
        people.put("a", "q");
        people.put("a", "w");
        people.put("a", "e");
        people.put("s", "r");
        people.put("d", "t");
        people.put("f", "t");
        people.put("f", "y");
        people.put("g", "u");
        people.put("h", "u");
        people.put("j", "u");

        return people;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
