package com.pluralsight.pizzalicious;

import java.util.ArrayList;
import java.util.List;

public class Order {

    //---------------Store all drinks and pizzas for this order------------
    private List<Drink> drinks;
    private List<Pizza> pizzas;

    //----------------Construction initializes both lists-------------------
    public Order() {
        this.drinks = new ArrayList<>();
        this.pizzas = new ArrayList<>();
    }
    //---------------Add drinks---------------------------

    public void addDrink(Drink drink) {
        drinks.add(drink);
        System.out.println("✅ " + drink.getSize() + " " + drink.getFlavor() + " Added to order!");
    }

    public double getTotal() {
        double total = 0.0;
        for (Drink d : drinks) {
            total += d.getPrice();
        }
        for (Pizza p : pizzas) {
            total += p.calculatePrice();
        }
        return total;
    }

    //---------------Print Order Summery---------------

    public void printorder() {
        System.out.println("\n══════════Order Summary══════════");
        if (drinks.isEmpty() && pizzas.isEmpty()) {
            System.out.println(" No items in your order yet!");
            return;
        }
        if (!pizzas.isEmpty()) ;
        System.out.println("\n════PIZZAS════");
        for (Pizza p : pizzas) {
            System.out.println("➡️" + p.getDescription());
        }
        if (!drinks.isEmpty()) {
            System.out.println("\n════DRINKS════");
            for (Drink d : drinks) {
                d.displayInfo();
            }
        }
        System.out.printf("➡️" + "Total: $%.2f%n", getTotal());
        System.out.println("═════════════════════");
    }

    //-------clear order after checkout-------------
    public void clearOrder() {
        drinks.clear();
        pizzas.clear();
        System.out.println(" order cleared Successfully");
    }
}
