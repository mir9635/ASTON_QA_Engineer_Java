package org.springpattern;

public class Lesson_4 {
    public void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public void checkSumSign() {
        int a = 5;
        int b = 7;

        System.out.println(((a + b) >= 0) ? "Сумма положительная." : "Сумма отрицательная.");
    }

    public void printColor() {
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный");
        } else if(value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public void compareNumbers() {
        int a = 7;
        int b = 7;

        System.out.println(a>=b ? "a >= b" : "a < b");
    }

    public boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public void OutputPositiveOrNegativeResult(int number) {
        System.out.println((number >= 0) ? "Положительное число" : "Отрицательное число");
    }

    public boolean OutputNegativeOrPositiveBoolean (int number) {
        return number < 0;
    }

    public void  printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    public boolean thisLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public int[] inversionNumber(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    public int[] creatingArray(int len, int initialValue) {

        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;

    }
}
