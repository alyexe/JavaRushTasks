package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args){
        //напишите тут ваш код
        Human grandpa1 = new Human();
        Human grandpa2 = new Human();
        Human grandma1 = new Human();
        Human grandma2 = new Human();
        Human father = new Human();
        Human mother = new Human();
        Human child1 = new Human();
        Human child2 = new Human();
        Human child3 = new Human();

        //Ребенок 1
        child1.name = "Vasya";
        child1.age = 18;
        child1.sex = true;

        //Ребенок 2
        child2.name = "Olya";
        child2.age = 15;
        child2.sex = false;

        //Ребенок 3
        child3.name = "Misha";
        child3.age = 10;
        child3.sex = true;

        //Папа
        father.name = "Papa";
        father.age = 40;
        father.sex = true;
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);

        //Мама
        mother.name = "Mama";
        mother.age = 36;
        mother.sex = false;
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        //Дедушка 1
        grandpa1.name = "Ded-1";
        grandpa1.age = 70;
        grandpa1.sex = true;
        grandpa1.children.add(father);

        //Дедушка 2
        grandpa2.name = "Ded-2";
        grandpa2.age = 65;
        grandpa2.sex = true;
        grandpa2.children.add(mother);

        //Бабушка 1
        grandma1.name = "Baba - 1";
        grandma1.age = 68;
        grandma1.sex = false;
        grandma1.children.add(father);

        //Бабушка 2
        grandma2.name = "Baba - 2";
        grandma2.age = 64;
        grandma2.sex = false;
        grandma2.children.add(mother);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandpa1);
        System.out.println(grandpa2);
        System.out.println(grandma1);
        System.out.println(grandma2);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
