package com.pluralsight.model.topping;



public abstract class PremiumTopping extends Topping {

    private boolean isExtra;


    public PremiumTopping(String name) {
        super(name);
        this.isExtra = false;

    }

    public boolean isExtra()              { return isExtra; }
    public void setExtra(boolean extra) { this.isExtra = extra; }


    public boolean isPremium() { return true; }

    public abstract double getPrice(String size);
}
