package com.pluralsight.pizzalicious;

import java.util.ArrayList;

public class Order {
    private ArrayList<Drink> drinks = new ArrayList<>();

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public double getTotal() {
        double total = 0;
        for (Drink d : drinks) {
            total += d.getPrice();
        }
        return total;
    }

    public void printorder() {
        if (drinks.isEmpty()) {
            System.out.println("No drink in your order yet. ");
            return;
        }
        System.out.println("Order Summary: ");
        for (Drink d : drinks) {
            System.out.println("- " + d.getDescription());
        }
        System.out.printf("Total: $%.2f%n", getTotal());
    }

    public void clearOrder() {
        drinks.clear();
        System.out.println(" order cleared Successfully");
    }
}
