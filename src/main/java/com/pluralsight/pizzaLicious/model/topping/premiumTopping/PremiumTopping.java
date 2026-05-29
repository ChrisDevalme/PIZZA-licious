package com.pluralsight.pizzaLicious.model.topping.premiumTopping;


import com.pluralsight.pizzaLicious.model.topping.Topping;

public abstract class PremiumTopping extends Topping {



    public PremiumTopping(String name) {
        super(name);
    }



    public boolean isPremium() { return true; }

    public abstract double getPrice(String size);
}
