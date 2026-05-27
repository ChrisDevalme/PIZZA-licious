package com.pluralsight.model;

import com.pluralsight.model.topping.Topping;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements OrderItem{
    private String size;
    private String crust;
    private boolean stuffedCrust;
    private List<Topping> toppings;

    public Pizza(String size, String crust, boolean stuffedCrust, List<Topping> toppings) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.toppings = toppings;
    }

    public Pizza(String size, String crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();
    }

    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getCrust() { return crust; }
    public void setCrust(String crust) { this.crust = crust; }
    public boolean isStuffedCrust() { return stuffedCrust; }
    public void setStuffedCrust(boolean isStuffedCrust) { this.stuffedCrust = isStuffedCrust; }

    public void addTopping(Topping topping)      { toppings.add(topping); }
    public List<Topping> getToppings()     { return toppings; }

    @Override
    public double calculatePrice() {
        double total = getBasePrice();
        for (Topping t : toppings) {
            total += t.getPrice(size);
        }
        if (stuffedCrust) total += getStuffedCrustPrice();
        return total;
    }

    private double getBasePrice() {
        switch (size) {
            case "8":  return 8.50;
            case "12": return 12.00;
            case "16": return 16.50;
            default:  return 0.0;
        }
    }

    private double getStuffedCrustPrice() {
        switch (size) {
            case "8":  return 1.00;
            case "12": return 1.50;
            case "16": return 2.00;
            default:  return 0.0;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "🍕 Pizza | Size: %s\" | Crust: %s | Stuffed Crust: %s | Toppings: %s | Total: $%.2f",
                size, crust, stuffedCrust ? "Yes" : "No", toppings, calculatePrice()
        );
    }
}
