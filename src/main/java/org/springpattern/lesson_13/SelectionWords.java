package org.springpattern.lesson_13;

import java.util.HashMap;
import java.util.Map;

public class SelectionWords {
    String[] words;
    Map<String, Integer> wordCount;

    public SelectionWords(String[] words) {
        wordCount = new HashMap<>();
        this.words = words;
    }

    public void countingNumberWords() {
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
    }

    public void printListUniqueWords() {
        System.out.println("Список уникальных слов:");
        for (String word : wordCount.keySet()) {
            System.out.println(word);
        }
    }

    public void printNumberRepetitionsWord() {
        System.out.println("Количество повторений слов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " встречается " + entry.getValue() + " раз(а).");
        }
    }
}

