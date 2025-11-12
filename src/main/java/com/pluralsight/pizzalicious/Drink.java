package com.pluralsight.pizzalicious;

public class Drink {
    // Instance variable
    private String flavor;
    private String size;
    private double price;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
        setPrice(size); //⭐set the correct price based on size
    }
    // ⭐Sets the price of the drink based on its size.
    // ⭐uses a switch statement to decide the correct price.

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
            default: //⭐If size is invalid set price to 0 and print a warning
                System.out.println(" Invalid size entered for " + flavor + ". Setting price to $0.00");
                price = 0.00;
        }

    }
    // ---------------Getter used to read value--------------


    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    //-------------Methode to show the drink's description---------


    public String getDescription() {
        return size + " " + flavor + " - $" + String.format("%.2f", price);
    }

    // ⭐for quick testing, print directly

    public void displayInfo() {
        System.out.println(getDescription());
    }
}

