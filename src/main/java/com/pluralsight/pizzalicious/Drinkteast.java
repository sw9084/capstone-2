package com.pluralsight.pizzalicious;

public class Drinkteast {
    public static void main(String[] args) {

        Drink d1 = new Drink("coke", "Small");
        Drink d2 = new Drink("Sprite", "Large");
        Drink d3 = new Drink("Lemonade", "Medium");

        d1.displayInfo();
        d2.displayInfo();
        d3.displayInfo();

        Order order = new Order();
        order.addDrink(d1);
        order.addDrink(d2);
        order.addDrink(d3);

        System.out.println("\n====Testing Drink and order Classes ====");
        order.printorder();

        double expectedTotal = 2.00 + 3.00 + 2.50;
        System.out.printf("\nExpected total: $%.2f%n", expectedTotal);
        System.out.printf(" Actual total: $%.2f%n", order.getTotal());
    }
}
