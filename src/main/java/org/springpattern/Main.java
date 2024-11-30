package org.springpattern;

import org.springpattern.lesson_6.Park;
import org.springpattern.lesson_6.Person;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 22);
        persArray[1] = new Person("Alexander Petrov", "Engineer", "petrov@mailbox.com", "892542312", 70000, 30);
        persArray[2] = new Person("Ekaterina Smirnova", "Engineer", "smirnova@mailbox.com", "892123412", 80000, 33);
        persArray[3] = new Person("Anna Kuznetsova", "Engineer", "kuznetsova@mailbox.com", "892312718", 45000, 35);
        persArray[4] = new Person("Sergey Volkov", "Engineer", "volkov@mailbox.com", "892312987", 10000, 20);



        for (Person person : persArray) {
            person.printInfoPerson();
        }


        Park park = new Park();
        park.addAttraction("Roller Coaster", "10-21", 25);
        park.printAttraction();




    }
}