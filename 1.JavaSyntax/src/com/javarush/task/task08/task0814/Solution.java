package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i*2);
        }
        return set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        Iterator<Integer> i = set.iterator(); //при неявном использовании итератора исключение ConcurrentModificationException
        while (i.hasNext()){
            if (i.next() > 10) i.remove();
        }
        return set;

    }

    public static void main(String[] args) {

    }
}
