package com.pluralsight.pizzaLicious.model.topping.premiumTopping;

import java.util.ArrayList;
import java.util.List;

public class CheeseTopping extends PremiumTopping {

    private static final List<CheeseTopping> CHEESES = new ArrayList<>();

    static {
        CHEESES.add(new CheeseTopping("Mozzarella"));
        CHEESES.add(new CheeseTopping("Parmesan"));
        CHEESES.add(new CheeseTopping("Ricotta"));
        CHEESES.add(new CheeseTopping("Goat Cheese"));
        CHEESES.add(new CheeseTopping("Buffalo"));
    }

    public static List<CheeseTopping> getAll() { return CHEESES; }

    public CheeseTopping(String name) {
        super(name);
    }

    public double getPrice(String size) {
        double base;
        double extraRate;

        switch (size) {
            case "8":
                base      = 1.00;
                extraRate = 0.50;
                break;
            case "12":
                base      = 2.00;
                extraRate = 1.00;
                break;
            case "16":
                base      = 3.00;
                extraRate = 1.50;
                break;
            default:
                return 0.0;
        }

        return isExtra() ? base + extraRate : base;
    }
}