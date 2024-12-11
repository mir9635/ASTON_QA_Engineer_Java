package org.springpattern.lesson_10.task2;

public class Triangle implements Figure {
    private double a, b, c;
    private double height;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, double height, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }



    public double calculatePerimeter() {
        return calculatePerimeter(a, b, c);
    }


    public double calculateArea() {
        return calculateArea(a, height);
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
        System.out.println("**Треугольник:**");
        Figure.super.printDetails();
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println();
    }



}
