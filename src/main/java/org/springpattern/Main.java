package org.springpattern;

import org.springpattern.lesson_10.task1.*;
import org.springpattern.lesson_10.task2.Circle;
import org.springpattern.lesson_10.task2.Figure;
import org.springpattern.lesson_10.task2.Rectangle;
import org.springpattern.lesson_10.task2.Triangle;
import org.springpattern.lesson_6.Park;
import org.springpattern.lesson_6.Person;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Dog dogBobik = new Dog("Бобик");
        Cat catMurka = new Cat("Мурка");


        dogBobik.run(555);
        dogBobik.swim(5);
        catMurka.run(150);
        catMurka.swim(5);

        System.out.println("Количество животных: " +AnimalCounter.getTotalAnimals());
        System.out.println("Количество собак: " +AnimalCounter.getTotalDogs());
        System.out.println("Количество котов: " +AnimalCounter.getTotalCats());

        System.out.println("\n");


        Dish dish = new Dish(15);
        Cat[] cats = {

                new Cat("Барсик"),
                new Cat("Василий"),
                new Cat("Снежок"),
                new Cat("Мурзик")
        };


        for (Cat cat : cats) {
            cat.eat(dish);
        }

        System.out.println("\nИнформация о котах:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + (cat.isSatiety() ? "Да" : "Нет"));
        }

        System.out.println("\nДобавляем еду в миску...");
        dish.addFood(20);
        for (Cat cat : cats) {
            cat.eat(dish);
        }

        System.out.println("\nИнформация о котах (финальная):");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + (cat.isSatiety() ? "Да" : "Нет"));
        }

        Figure circle = new Circle(5, "Красный", "Черный");
        Figure rectangle = new Rectangle(4, 7, "Синий", "Зеленый");
        Figure triangle = new Triangle(3, 4, 5, 2.5, "Желтый", "Фиолетовый");

        circle.printDetails();
        rectangle.printDetails();
        triangle.printDetails();

    }
}