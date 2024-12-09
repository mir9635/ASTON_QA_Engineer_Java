package org.springpattern.lesson_10.task1;

public class Cat extends Animal {
    public static int runningDistance = 200;

    private boolean satiety = false;


    public Cat() {
        super("Безымянный кот", runningDistance);

    }

    public Cat(String name) {
        super(name, runningDistance);
        this.name = name;
        AnimalCounter.incrementCatsCounter();
    }


    @Override
    public void swim(int distance) {
        System.out.println(String.format("Кот %s не умеет плавать",name));
    }


    public boolean isSatiety() {
        return satiety;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void eat(Dish bowl) {
        if (!satiety && bowl.decreaseFood(10)) {
            this.satiety = true;
            System.out.println(name + " поел и стал сытым.");
        } else if (satiety){
            System.out.println(name + " сыт");
        }else {
            System.out.println(name + " не смог поесть (еду в миске не хватает).");
        }
    }
}
