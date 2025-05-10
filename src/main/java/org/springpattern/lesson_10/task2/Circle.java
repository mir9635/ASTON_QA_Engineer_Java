package org.springpattern.lesson_10.task2;

public class Circle implements Figure {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }


    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }


    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void printDetails() {
        System.out.println("**Круг:**");
        Figure.super.printDetails();
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println();
    }
}
