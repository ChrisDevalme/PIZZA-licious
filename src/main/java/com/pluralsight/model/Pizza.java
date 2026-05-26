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

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getCrust() { return crust; }
    public void setCrust(String crust) { this.crust = crust; }
    public boolean isStuffedCrust() { return stuffedCrust; }
    public void setStuffedCrust(boolean isStuffedCrust) { this.stuffedCrust = isStuffedCrust; }


    @Override
    public double calculatePrice() {
        return 0;
    }
}
