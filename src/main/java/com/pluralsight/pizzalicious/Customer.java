package com.pluralsight.pizzalicious;

public class Customer {
    //--------------Fields---------------------
    private String name;
    private String phoneNumber;
    private boolean isDelivery; // true = delivery, false = pickup
    private String address; // only apply for delivery

    //------------Constructor----------------------
    public Customer(String name, String phoneNumber, boolean isDelivery, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isDelivery = isDelivery;
        this.address = address;
    }

    //------------Getter------------------------------
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public String getAddress() {
        return address;
    }

    //-----------Helper Method-----------------------
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("👤 Customer Name: ").append(name).append("\n");
        sb.append("📞Phone ").append(phoneNumber).append("\n");
        if (isDelivery) {
            sb.append("🚚 Delivery to: ").append(address).append("\n");
        } else {
            sb.append("🏠 Pickup order\n");
        }
        return sb.toString();
    }

}
