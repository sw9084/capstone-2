package com.pluralsight.pizzalicious;

public class Topping {
    private final String name;
    private final String category;
    private final boolean extra;

    //-------------Construction----------------
    public Topping(String name, String category, boolean extra) {
        this.name = name;
        this.category = category.toLowerCase();
        this.extra = extra;
    }

    // ----------Getter----------------------
    public String getName() {
        return name;
    }

    //----------calculate topping price----------
    public double getPrice(String size) {
        double price = 0.0;
        switch (category) {
            case "meat":
                price = switch (size.toLowerCase()) {
                    case "8", "8\"", "personal" -> 1.00;
                    case "12", "medium" -> 1.50;
                    case "16", "large" -> 2.25;
                    default -> 0.0;
                };
                if (extra) price += 0.25;
                break;
            case "regular":
                price = 0.0;
                break;
        }
        return price;
    }
}
