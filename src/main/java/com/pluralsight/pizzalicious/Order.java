package com.pluralsight.pizzalicious;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private static final double TAX_RATE = 0.0825;
    private static final double DELIVERY_FEE = 3.99;

    //---------------Store all drinks and pizzas for this order------------
    private List<Drink> drinks;
    private List<Pizza> pizzas;

    private Customer customer;

    //----------------Construction initializes both lists-------------------
    public Order() {
        this.drinks = new ArrayList<>();
        this.pizzas = new ArrayList<>();
    }
        public List<Pizza> getPizzas() {
          return pizzas;
    }
      public List<Drink> getDrinks() {
        return drinks;
      }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    //---------------Add drinks---------------------------

    public void addDrink(Drink drink) {
        drinks.add(drink);

    }

    public double getTotal() {
        double subtotal = 0.0;
        for (Drink d : drinks) {
            subtotal += d.getPrice();
        }

        for (Pizza p : pizzas) {
            subtotal += p.calculatePrice();
        }
        double tax = subtotal * TAX_RATE;
        double delivery = (customer != null && customer.isDelivery()) ? DELIVERY_FEE : 0;
        return subtotal + tax + delivery;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    //---------------Print Order Summery---------------

    public void printOrder() {
        double subtotal = getTotal();
        double tax = subtotal * TAX_RATE;
        double delivery = customer.isDelivery() ? DELIVERY_FEE : 0.0;

        System.out.println("\n══════════Order Summary══════════");
        if (customer != null) {
            System.out.println("\n👤═══════Customer Information═════");
            System.out.println(customer.getSummary());
        } else {
            System.out.println("\n Customer information not provided.");
        }
        if (drinks.isEmpty() && pizzas.isEmpty()) {
            System.out.println(" No items in your order yet!");
            return;
        }
        if (!pizzas.isEmpty()) {
            System.out.println("\n════PIZZAS════");
            for (Pizza p : pizzas) {
                System.out.println(" " + p.getDescription());
            }
            if (!drinks.isEmpty()) {
                System.out.println("\n════DRINKS════");
                for (Drink d : drinks) {
                    d.displayInfo();
                }
            }
            System.out.printf("\n Subtotal: $%.2f", subtotal);
            System.out.printf("\n Tax (8.25%%): $%.2f", tax);

            if (delivery > 0) {
                System.out.println("\n 🚚 Delivery Fee: $%.2f, delivery");
            }
            System.out.printf("\n💲Total: $%.2f%n", (subtotal + tax + delivery));
            System.out.println("═════════════════════");
        }
    }


    //-------clear order after checkout-------------
    public void clearOrder() {

        drinks.clear();
        pizzas.clear();
        System.out.println(" order cleared Successfully");
    }
}

