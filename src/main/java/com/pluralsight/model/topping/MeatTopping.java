package com.pluralsight.model.topping;

import java.util.ArrayList;
import java.util.List;

public class MeatTopping extends PremiumTopping {

    private static final List<MeatTopping> MEATS = new ArrayList<>();

    static {
        MEATS.add(new MeatTopping("Pepperoni"));
        MEATS.add(new MeatTopping("Sausage"));
        MEATS.add(new MeatTopping("Ham"));
        MEATS.add(new MeatTopping("Bacon"));
        MEATS.add(new MeatTopping("Chicken"));
        MEATS.add(new MeatTopping("Meatball"));
    }

    public static List<MeatTopping> getAll() { return MEATS; }

    public MeatTopping(String name) {
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