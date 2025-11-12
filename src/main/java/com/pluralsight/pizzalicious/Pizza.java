package com.pluralsight.pizzalicious;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String size;           // 8, 12, 16
    private String crust;          // thin, regular, thick, cauliflowe
    private boolean stuffedCrust;
    private final List<Topping> toppings;         // will hold meat/cheese/regular topping
    private  final double basePrice;

    // -------------------Constructor--------------------------
    public Pizza(String size, String crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();
        this.basePrice = setBasePrice(size); // calls helper method below
    }
    // ------------------Helper: set base price--------------------
    private double setBasePrice(String size) {
        switch (size.toLowerCase()) {
            case "8":
            case "8\"":
            case "personal":
                return 8.50;
            case "medium":
                return 12.00;
            default:
                return 0.0;
        }
    }
    //-----------------Add topping------------------------
    public void addTopping (Topping topping) {
        toppings.add(topping);
    }
    //-----------------Calculate total price----------------
    public double calculatePrice() {
        double total = basePrice;
        for (Topping t : toppings) {
            total += t.getPrice(size);
        }
        // Add small fee for stuffed crust
        if(stuffedCrust) {
            total += 1.00;
        }
        return total;
    }
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nToppings: ");
        if(toppings.isEmpty()) {
            sb.append(("No topping"));
        } else {
            for (Topping t : toppings) {
                sb.append(sb.append(t.getName()).append(", "));
            }
            sb.delete(sb.length() -2, sb.length());
        }
        sb.append(String.format("\nPrice: $%.2f", calculatePrice()));
        return sb.toString();

    }

}
