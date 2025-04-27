package org.springpattern.lesson_12;

import org.springpattern.myexceptions.MyArrayDataException;
import org.springpattern.myexceptions.MyArraySizeException;

public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int expectedSize = 4;

        if (array.length != expectedSize) {
            throw new MyArraySizeException("Некорректный размер массива. Ожидается массив 4х4.");
        }
        for (String[] row : array) {
            if (row.length != expectedSize) {
                throw new MyArraySizeException("Некорректный размер массива. Ожидается массив 4х4.");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в данных: неверное значение в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}
