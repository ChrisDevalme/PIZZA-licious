package com.pluralsight.pizzaLicious.model.topping.regularTopping;

import com.pluralsight.pizzaLicious.model.topping.Topping;

import java.util.ArrayList;
import java.util.List;

public class RegularTopping extends Topping {

    private static final List<RegularTopping> OPTIONS = new ArrayList<>();


    static {
        OPTIONS.add(new RegularTopping("Onions"));
        OPTIONS.add(new RegularTopping("Mushrooms"));
        OPTIONS.add(new RegularTopping("Bell Peppers"));
        OPTIONS.add(new RegularTopping("Olives"));
        OPTIONS.add(new RegularTopping("Tomatoes"));
        OPTIONS.add(new RegularTopping("Spinach"));
        OPTIONS.add(new RegularTopping("Basil"));
        OPTIONS.add(new RegularTopping("Pineapple"));
        OPTIONS.add(new RegularTopping("Anchovies"));
    }

    public static List<RegularTopping> getAll() { return OPTIONS; }

    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public boolean isPremium() {
        return false;
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }
}
