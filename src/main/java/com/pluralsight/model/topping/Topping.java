package com.pluralsight.model.topping;

public abstract class Topping {

    private String name;

    public Topping(String name) {
        this.name     = name;
    }

    public String getName()             { return name; }


    public abstract boolean isPremium();
    public abstract double  getPrice(String size);
}