package org.springpattern.lesson_6;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private List<Attraction> attractions;

    public Park() {
        this.attractions = new ArrayList<>();
    }



    private class Attraction {
        private String name;
        private String operatingHours;
        private int price;


        public Attraction(String name, String operatingHours, int price) {
            this.name = name;
            this.operatingHours = operatingHours;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Аттракцион: %s, Режим работы: %s, Цена: %d.", name, operatingHours, price);
        }
    }

    public void addAttraction(String name, String operatingHours, int price) {
        attractions.add(new Attraction(name, operatingHours, price));
    }

    public void printAttractions() {
        if (attractions.isEmpty()) {
            System.out.println("В парке пока нет аттракционов.");
        } else {
            System.out.println("Список всех аттракционов в парке:");
            for (Attraction attraction : attractions) {
                System.out.println(attraction.toString());
            }
        }
    }

}
