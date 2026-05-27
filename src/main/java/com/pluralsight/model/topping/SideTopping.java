package com.pluralsight.model.topping;

import java.util.ArrayList;
import java.util.List;

public class SideTopping extends Topping {

    private static final List<SideTopping> OPTIONS = new ArrayList<>();

    static {
        OPTIONS.add(new SideTopping("Red Pepper"));
        OPTIONS.add(new SideTopping("Parmesan"));
    }

    public static List<SideTopping> getAll() { return OPTIONS; }

    public SideTopping(String name) { super(name); }

    public boolean isPremium() { return false; }
    public double  getPrice(String size) { return 0.0; }
}