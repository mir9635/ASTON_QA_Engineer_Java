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

    public void printInfoPerson() {
        System.out.println(String.format("Ф.И.О: %s, Должность: %s, email: %s, Телефон: %s, Зарплата: %d, Возраст: %d.",
                this.name, this.position, this.email, this.phone, this.salary, this.age));
    }
}
