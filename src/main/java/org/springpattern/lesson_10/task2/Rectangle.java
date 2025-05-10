package org.springpattern.lesson_10.task2;

public class Rectangle implements Figure {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }


    public double calculatePerimeter() {
        return calculatePerimeter(width, height, width, height);
    }


    public double calculateArea() {
        return calculateArea(width, height);
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
        System.out.println("**Прямоугольник:**");
        Figure.super.printDetails();
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println();
    }
}
