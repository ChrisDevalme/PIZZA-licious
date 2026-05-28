package com.pluralsight.model.topping.regularTopping;

import com.pluralsight.model.topping.Topping;

import java.util.ArrayList;
import java.util.List;

public class SauceTopping extends Topping {

    private static final List<SauceTopping> OPTIONS = new ArrayList<>();

    static {
        OPTIONS.add(new SauceTopping("Marinara"));
        OPTIONS.add(new SauceTopping("Alfredo"));
        OPTIONS.add(new SauceTopping("Pesto"));
        OPTIONS.add(new SauceTopping("BBQ"));
        OPTIONS.add(new SauceTopping("Buffalo"));
        OPTIONS.add(new SauceTopping("Olive Oil"));
    }

    public static List<SauceTopping> getAll() { return OPTIONS; }

    public SauceTopping(String name) { super(name); }

    public boolean isPremium() { return false; }
    public double  getPrice(String size) { return 0.0; }
}