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
    public Pizza(String size, String crust, boolean stuffedCrust, double basePrice) {
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
        sb.append("\n═══════════ Pizza Summary ══════════\n");
        sb.append("➡️Size: ").append(size);
        sb.append("\n➡️Crust: ").append(crust);
        if (stuffedCrust) sb.append(" (stuffed)");
        sb.append("\n➡️Toppings: ");
        if(toppings.isEmpty()) {
            sb.append(("❌No topping"));
        } else {
            for (Topping t : toppings) {
                sb.append(t.getName()).append(", ");
            }
            sb.setLength(sb.length() -2);
        }
        sb.append(String.format("\n💲Price: $%.2f\n", calculatePrice()));
        sb.append("═══════════════════════════");
        return sb.toString();

    }

}
