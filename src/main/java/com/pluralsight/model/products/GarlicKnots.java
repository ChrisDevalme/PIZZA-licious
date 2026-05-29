package com.pluralsight.model.products;

import com.pluralsight.model.order.OrderItem;

public class GarlicKnots implements OrderItem {
    private String flavor;
    private String count;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public double calculatePrice() {
        double price;
        switch(count){
            case "6":
                price = 1.50;
                break;
            case "12":
                price = 2.50;
                break;
            case "18":
                price = 4.00;
                break;
            default:
                return 0.0;
        }
        return price;
    }

    public String toString() {
        return String.format("🥐 Garlic Knots | count: %s | Flavor: %s | Total: $%.2f", count, flavor, calculatePrice());
    }

    @Override
    public String getName() {
        return "Garlic Knots";
    }
}
