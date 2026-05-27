package com.pluralsight.model.topping;



public abstract class PremiumTopping extends Topping {



    public PremiumTopping(String name) {
        super(name);
    }



    public boolean isPremium() { return true; }

    public abstract double getPrice(String size);
}
