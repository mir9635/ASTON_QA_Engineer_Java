package org.springpattern.lesson_10.task2;

public interface Figure {
    String getFillColor();
    String getBorderColor();

    default double calculatePerimeter(double... sides) {
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }
     default double calculateArea(double... params) {
         if (params.length == 2) {
             return params[0] * params[1];
         } else if (params.length == 3) {
             return (params[0] * params[1]) / 2;
         }
         return 0;
     }

    default void printDetails() {
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}
