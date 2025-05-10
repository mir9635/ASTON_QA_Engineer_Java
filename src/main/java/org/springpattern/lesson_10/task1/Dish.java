package org.springpattern.lesson_10.task1;

public class Dish {
    private int foodAmount;

    public Dish(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        foodAmount += Math.max(amount, 0);
        System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
    }
}
