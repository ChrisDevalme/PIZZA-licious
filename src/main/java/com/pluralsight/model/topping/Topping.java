package com.pluralsight.model.topping;

public abstract class Topping {

    private String name;

    public Topping(String name) {
        this.name     = name;
    }

    public String getName()             { return name; }


    public abstract boolean isPremium();
    public abstract double  getPrice(String size);

    @Override
    public String toString() {
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}