package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа
*/

/*

1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774, 32164049650, 32164049651, 40028394225, 42678290603, 44708635679, 49388550606, 82693916578, 94204591914, 28116440335967, 4338281769391370, 4338281769391371, 21897142587612075, 35641594208964132, 35875699062250035, 1517841543307505039, 3289582984443187032, 4498128791164624869, 4929273885928088826
1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 9474, 54748, 92727, 548834, 1741725, 4210818, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774, 32164049650, 32164049651, 40028394225, 42678290603, 44708635679, 49388550606, 82693916578, 28116440335967, 4338281769391370, 4338281769391371, 21897142587612075, 35641594208964132, 35875699062250035, 1517841543307505039, 3289582984443187032, 4498128791164624869, 4929273885928088826

4150
4151
564240140138
233411150132317
 */


public class Solution {
    private static long[][] matrix;                         //Таблица подбора степеней
    private static int digits;                              //Количество цифр в числе
    private static long[] array;                            //Массив уникальных чисел
    private static final Set<Long> set = new TreeSet<>();   //результирующий набор чисел Армстронга
    private static long max;                                //Максимальное число, до которого надо найти числа Армстронга (пункт 3 требований)


    public static void main(String[] args) {
        long a, b;

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
        System.out.println(set.size());

/*
        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
*/

    }

    public static long[] getNumbers(long N) {

        if (N < 0) return new long[0];                     //если число отрицательное - возвращаем пустой массив

        set.clear();
        max = N;
        digits = getNumOfDigits(N);                         //Считаем количество цифр в числе
        genMatrix(digits);                                  //Генерируем матрицу степеней
        array = new long[digits];                           //Массив уникальных чисел

        while (arrayFill()) {                               //Заполняет массив уникальных чисел
            isArmstrong(array);                             //И сразу проверяем текущее число
        }

        Long[] tmpresult = new Long[0];                     //Переносим наши числа из набора Set
        tmpresult = set.toArray(tmpresult);                 //Сначала в массив массивов long[]
        long[] result = new long[tmpresult.length];         //А затем в массив long
        for (int i = 0; i < tmpresult.length; i++) result[i] = tmpresult[i];
        return result;
    }

    private static void isArmstrong(long[] l) {
        long current = arrayToLong(l);                      //Получаем из массива цифр уникальное число
        if (current < 0) return;                            //Если оно отрицательное - уходим
        int n = getNumOfDigits(current);                    //Получаем количество цифр в числе
        while (n <= digits) {                               //Пока количество цифр не станет равно количеству цифр в исходном числе
            long temp = getSum(l, n);                       //Получаем сумму степеней числа по степени текущего количества цифр
            if (temp >= max || temp < -1) return;
            if (Arrays.equals(l, longToArray(temp))) {      //Если сумма степеней равна числу - добавляем это число в итоговый набор
                set.add(temp);
            }
            n++;
        }
    }

    private static long getSum(long[] l, int pow) {
        long sum = 0;
        if (pow > digits) return -1;
        for (long l1 : l) {
            try {
                sum += matrix[(int)l1][pow - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        if (getNumOfDigits(sum) != pow) return -1;
        return sum;
    }

    private static long[] longToArray(long l) {
        //Переводим число в массив цифр
        if (getNumOfDigits(l) > digits) return null;
        int n = digits; //getNumOfDigits(l);
        int i = n - 1;
        long temp = l;
        long[] result = new long[n];
        while (temp > 0) {
            temp %= 10;
            result[i] = temp;
            temp = l / 10;
            l = temp;
            i--;
        }
        Arrays.sort(result);
        return result;
    }

    private static int getNumOfDigits(long n) {
        //Вычисляем кол-во цифр в числе
        int numOfDigits = 1;                                //кол-во цифр в проверяемом числе
        while ((n /= 10) > 0) numOfDigits++;
//        if (numOfDigits > 20) return -1;                    //Если цифр в числе больше 20, возвращаем -1, т.к. число больше long
        return numOfDigits;
    }

    private static void genMatrix(int numOfDigits) {
        //заполняем матрицу степеней цифр от 1 до 9 в степень кол-ва цифр в исходном числе
        matrix = new long[10][numOfDigits];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < numOfDigits; j++) {
                int z = j + 1;
                long mult = 1;
                while (z > 0) {
                    mult *= i;
                    z--;
                }
                matrix[i][j] = mult;
            }
        }
    }

    private static long arrayToLong(long[] array) {
        //Переводим массив цифр в число
        long result = 0;
        for (long l : array) {
            result = result * 10 + l;
        }
        if (result < 0) return -1; //Если в массиве чисел больше, чем знаков в long, возвращаем -1
        return result;
    }

    private static boolean arrayFill() {
        //Заполняем массив уникальными числами

        int index = array.length - 1;
        while (index > 0 && array[index] == 9) {
            index--;
        }
        if (index == 0 && array[index] == 9) return false;
        Arrays.fill(array, index, array.length, ++array[index]);
        return true;
    }
}
