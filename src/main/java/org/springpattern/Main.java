package org.springpattern;

import org.springpattern.lesson_13.PhoneDirectory;
import org.springpattern.lesson_13.SelectionWords;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] words = {"красный", "синий", "желтый", "зеленый", "синий",
                "черный", "красный", "белый", "фиолетовый", "зеленый",
                "оранжевый", "желтый", "синий", "красный", "белый"};


        SelectionWords selectionWords = new SelectionWords(words);
        selectionWords.countingNumberWords();
        selectionWords.printListUniqueWords();
        selectionWords.printNumberRepetitionsWord();

        System.out.println();

        PhoneDirectory phoneBook = new PhoneDirectory();


        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Петров", "234-567");
        phoneBook.add("Иванов", "345-678");

        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Сидоров"));

    }
}