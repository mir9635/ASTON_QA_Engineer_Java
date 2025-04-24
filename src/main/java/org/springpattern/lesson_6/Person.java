package org.springpattern.lesson_6;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Ф.И.О: %s, Должность: %s, email: %s, Телефон: %s, Зарплата: %d, Возраст: %d.",
                name, position, email, phone, salary, age);
    }

}
