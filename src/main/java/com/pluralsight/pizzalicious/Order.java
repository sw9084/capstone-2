package com.pluralsight.pizzalicious;

import java.util.ArrayList;

public class Order {
    // ====================================
    // ⭐Fields (Attributes)
    // ====================================
    private ArrayList<Drink> drinks = new ArrayList<>();
    // ====================================
    //⭐Methods
    // Add a new drink object to the order
    // calculate the total price of all drink in the order
    // ====================================

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

    /** Display the list of drinks and the total price.
     * This will be used by the User Interface (MainApp)
     */

    public void printorder() {
        if (drinks.isEmpty()) {
            System.out.println("No drink in your order yet. ");
            return;
        }
        System.out.println("Order Summary:");
        for (Drink d : drinks) {
            System.out.println("➡️" + d.getDescription());
        }
        System.out.printf("➡️" +"Total: $%.2f%n", getTotal());
    }

    /** Clear all items from the order
     */

    public void clearOrder() {
        drinks.clear();
        System.out.println(" order cleared Successfully");
    }
}
