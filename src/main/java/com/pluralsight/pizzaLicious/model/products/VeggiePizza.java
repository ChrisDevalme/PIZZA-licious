package com.pluralsight.pizzaLicious.model.products;

import com.pluralsight.model.topping.premiumTopping.*;
import com.pluralsight.model.topping.regularTopping.*;
import com.pluralsight.pizzaLicious.model.topping.premiumTopping.CheeseTopping;
import com.pluralsight.pizzaLicious.model.topping.regularTopping.RegularTopping;
import com.pluralsight.pizzaLicious.model.topping.regularTopping.SauceTopping;

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