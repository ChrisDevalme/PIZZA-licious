package com.pluralsight.pizzaLicious;

import com.pluralsight.pizzaLicious.util.UserInterface;


public class App {
    public static final String RED = "\u001B[31m";
    public static final String Default = "\u001B[0mm";

    public static void main(String[] args) {
        UserInterface user = new UserInterface();
        user.display();
    }
}
