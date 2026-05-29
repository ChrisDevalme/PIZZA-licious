package com.pluralsight.model.products;

import com.pluralsight.model.topping.premiumTopping.*;
import com.pluralsight.model.topping.regularTopping.*;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        super("8", "Regular", false);

        addTopping(new RegularTopping("Bell Peppers"));
        addTopping(new RegularTopping("Spinach"));
        addTopping(new RegularTopping("Olives"));
        addTopping(new RegularTopping("Onions"));
        addTopping(new SauceTopping("Marinara"));
        addTopping(new CheeseTopping("Mozzarella"));
    }

    @Override
    public String getName() {
        return "Veggie Pizza";
    }
}