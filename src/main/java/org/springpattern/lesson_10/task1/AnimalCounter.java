package org.springpattern.lesson_10.task1;

public class AnimalCounter {
    private static int totalAnimals = 0;
    private static int totalDogs = 0;
    private static int totalCats = 0;

    public static void incrementAnimalsCounter() {
        totalAnimals++;
    }

    public static void incrementDogsCounter() {
        totalDogs++;
    }

    public static void incrementCatsCounter() {
        totalCats++;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    public static int getTotalDogs() {
        return totalDogs;
    }

    public static int getTotalCats() {
        return totalCats;
    }
}
