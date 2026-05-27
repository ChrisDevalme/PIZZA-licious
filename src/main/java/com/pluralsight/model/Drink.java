package com.pluralsight.model;


public class Drink implements OrderItem{

    private String flavor;
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice() {
        double price;
        switch(size){
            case "Small":
                price = 2.00;
                break;
            case "Medium":
                price = 2.50;
                break;
            case "Large":
                price = 3.00;
                break;
            default:
                return 0.0;
        }
        return price;
    }

    public String toString() {
        return String.format(
                "🥤 Drink | Size: %s | Flavor: %s | Total: $%.2f",
                size, flavor, calculatePrice()
        );
    }


}
