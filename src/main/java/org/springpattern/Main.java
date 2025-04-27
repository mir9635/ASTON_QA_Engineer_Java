package org.springpattern;

import org.springpattern.lesson_12.ArrayProcessor;
import org.springpattern.myexceptions.MyArrayDataException;
import org.springpattern.myexceptions.MyArraySizeException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        String[][] incorrectDataArray = {
                {"1", "2", "3", "4"},
                {"5", "abc", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"}
        };


        try {
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(correctArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(incorrectDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов: " + ArrayProcessor.processArray(wrongSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}