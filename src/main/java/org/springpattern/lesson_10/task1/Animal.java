package org.springpattern.lesson_10.task1;

public class Animal {
    String name;
    int runningDistance;

    public Animal(String name, int runningDistance) {
        this.name = name;
        this.runningDistance = runningDistance;
        AnimalCounter.incrementAnimalsCounter();
    }

    public void run(int distance) {
        if (distance <= runningDistance && distance >=0) {
            System.out.println(String.format("%s пробежал %d м.", name, distance));
        } else if (distance > runningDistance) {
            System.out.println("Дистанция слишком большая.");
        } else System.out.println("Дистанция не может быть отрицательной.");
    }
    public void swim(int distance) {

    }

    public String getName() {
        return name;
    }
}
