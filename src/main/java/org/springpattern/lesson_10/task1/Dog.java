package org.springpattern.lesson_10.task1;

public class Dog extends Animal {
    public static int runningDistance = 500;
    public static int swimmingDistance = 10;


    public Dog() {
        super("Безымянная собака", runningDistance);
    }


    public Dog(String name) {
        super(name, runningDistance);
        this.name = name;
        AnimalCounter.incrementDogsCounter();
    }


    @Override
    public void swim(int distance) {
        if (distance <= swimmingDistance && distance >=0) {
            System.out.println(String.format("%s проплыл %d м.", name, distance));
        } else if (distance > swimmingDistance) {
            System.out.println("Дистанция слишком большая.");
        } else System.out.println("Дистанция не может быть отрицательной.");
    }
}
