package com.pluralsight.pizzalicious;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String size;           // 8, 12, 16
    private String crust;          // thin, regular, thick, cauliflowe
    private boolean stuffedCrust;
    private List<Topping> topping;         // will hold meat/cheese/regular topping
    private double basePrice;

    // -------------------Constructor--------------------------
    public Pizza(String size, String crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.topping = new ArrayList<>();
        this.basePrice = setBasePrice(size); // calls helper method below

    }
}
