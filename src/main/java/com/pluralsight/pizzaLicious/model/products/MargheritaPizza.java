package com.pluralsight.pizzaLicious.model.products;

import com.pluralsight.pizzaLicious.model.topping.premiumTopping.*;
import com.pluralsight.pizzaLicious.model.topping.regularTopping.*;


public class MargheritaPizza extends Pizza {

    public MargheritaPizza() {
        super("12", "Regular", false);

        addTopping(new CheeseTopping("Mozzarella"));
        addTopping(new RegularTopping("Tomatoes"));
        addTopping(new RegularTopping("Basil"));
        addTopping(new SauceTopping("Marinara"));
        addTopping(new SauceTopping("Olive Oil"));
    }

    @Override
    public String getName() {
        return "Margherita Pizza";
    }
}