package org.springpattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Lesson_4 lesson4 = new Lesson_4();
        //1
        // lesson4.printThreeWords();

        //2
        //  lesson4.checkSumSign();

        //3
        // lesson4.printColor();

        //4
        // lesson4.compareNumbers();

        //5
        //System.out.println(lesson4.isSumInRange(54,1));

        //6
        //lesson4.OutputPositiveOrNegativeResult(-5);

        //7
        //System.out.println(lesson4.OutputNegativeOrPositiveBoolean(0));

        //8
        //lesson4.printStringMultipleTimes("text", 5);

        //9
        //System.out.println(lesson4.thisLeapYear(1104));

        //10
        int[] arrayInversion = {0, 1, 1, 0, 0, 1, 1, 0};
        int[] arrayInversionResult = lesson4.inversionNumber(arrayInversion);
//        for (int num : arrayInversionResult) {
//            System.out.print(num + " ");
//        }

        //11
        int[] arrayFilling  = new int[100];

        for (int i = 0; i < arrayFilling.length; i++) {
            arrayFilling[i] = i+1;
        }

//        for (int value : arrayFilling) {
//            System.out.println(value + " ");
//        }

        //12
        int[] arrayTransformations = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arrayTransformationsResult = new int[arrayTransformations.length];

        for (int i = 0; i < arrayTransformations.length; i++) {
            if (arrayTransformations[i] < 6) {
                arrayTransformationsResult[i] =arrayTransformations[i] * 2;
            } else arrayTransformationsResult[i] = arrayTransformations[i];
        }

//        for (int value : arrayTransformationsResult) {
//            System.out.print(value + " ");
//        }


        //13
        int[][] array = new int[4][4];

        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }


        //14
        int[] arrayCreateResult = lesson4.creatingArray(5,7);

//        for (int value : arrayCreateResult) {
//            System.out.print(value + " ");
//        }
//        System.out.println();

    }
}