package org.springpattern.lesson_6;

public class Park {
    private Attraction attraction;



    public class Attraction {
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
        attraction = new Attraction(name, operatingHours, price);
    }

    public void printAttraction() {
        System.out.println(attraction);
    }

}
