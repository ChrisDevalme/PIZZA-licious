package com.pluralsight.pizzaLicious.model.topping;

public abstract class Topping {

    private String name;
    private boolean isExtra;


    public Topping(String name) {
        this.name = name;
        this.isExtra = false;
    }

    public String getName() { return name; }
    public boolean isExtra() { return isExtra; }
    public void setExtra(boolean extra) { this.isExtra = extra; }


    public abstract boolean isPremium();
    public abstract double  getPrice(String size);

    @Override
    public String toString() {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}