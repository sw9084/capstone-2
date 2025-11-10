package com.pluralsight.pizzalicious;

public class Drink {
    private String flavor;
    private String size;
    private double price;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
        setPrice(size);
    }

    private void setPrice(String size) {
        switch (size.toLowerCase().trim()) {
            case "small":
                price = 2.00;
                break;
            case "medium":
                price = 2.50;
                break;
            case "large":
                price = 3.00;
                break;
            default:
                System.out.println(" Invalid size entered for " + flavor + ". Setting price to $0.00");
                price = 0.00;
        }

    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return size + " " + flavor + " - $" + String.format("%.2f", price);
    }

    public void displayInfo() {
        System.out.println(getDescription());
    }
}

