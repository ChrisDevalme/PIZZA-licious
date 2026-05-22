package com.pluralsight;

import com.pluralsight.model.Order;
import com.pluralsight.service.ReceiptService;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order currentOrder;
    private ReceiptService receiptService;

    public UserInterface(){
        scanner = new Scanner(System.in);
        receiptService = new ReceiptService();

    }

    public void logo() {
        System.out.println(
                        "██████╗ ██╗███████╗███████╗ █████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗\n" +
                        "██╔══██╗██║╚══███╔╝╚══███╔╝██╔══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝\n" +
                        "██████╔╝██║  ███╔╝   ███╔╝ ███████║██║     ██║██║     ██║██║   ██║██║   ██║███████╗\n" +
                        "██╔═══╝ ██║ ███╔╝   ███╔╝  ██╔══██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║\n" +
                        "██║     ██║███████╗███████╗██║  ██║███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║\n" +
                        "╚═╝     ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝\n"
                        +       "                           /\\\n" +
                        "                          /  \\\n" +
                        "                         / ** \\\n" +
                        "                        /*  ~ *\\\n" +
                        "                       / * ~  * \\\n" +
                        "                      /  * ~~ *  \\\n" +
                        "                     / .*  **  *. \\\n" +
                        "                    / .  *    *  . \\\n" +
                        "                   /________________\\\n" +
                        "                   \\________________/\n"
        );
    }

    public void display() {
        boolean quit = false;
        while (!quit){
            logo();
            System.out.println("=============== Welcome to PIZZALICIOUS ===============\n" +
                    " 1) New Order\n" +
                    " 0) Exit\n" +
                    "Your choice:");

            String userChoice = scanner.nextLine();
            if (!userChoice.equals("1") && !userChoice.equals("0")) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (userChoice) {
                case "1":
                    processNewOrder();
                    break;
                case "0":
                    quit = true;
            }
        }
    }

    public void processNewOrder() {
        createNewOrder();
        boolean ordering = true;
        while (ordering) {
            System.out.println(
                    "=====================  Order Menu =====================\n" +
                            " 1) Add Pizza\n" +
                            " 2) Add Drink\n" +
                            " 3) Add Garlic Knots\n" +
                            " 4) Checkout\n" +
                            " 5) Cancel Order\n" +
                            "Your choice:"
            );
            String userChoice = scanner.nextLine();
            if (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3") && !userChoice.equals("4")
            && !userChoice.equals("5")) {
                System.out.println("Invalid input.");
                continue;
            };

            switch (userChoice){
                case "1":
                    processAddPizza(currentOrder);
                    break;
                case "2":
                    processAddDrink(currentOrder);
                    break;
                case "3":
                    processAddGarlicKnots(currentOrder);
                    break;
                case "4":
                    processCheckout(currentOrder);
                    break;
                case "5":
                    ordering = false;
                    cancelOrder();
                    break;
            }
        }
    }
    public void processAddPizza(Order currentOrder){
        System.out.println("Adding pizza!");
    }
    public void processAddDrink(Order currentOrder) {
        System.out.println("Adding Drink!");
    }
    public void processAddGarlicKnots(Order currentOrder) {
        System.out.println("Adding Garlic Knots!");
    }
    public void processCheckout(Order currentOrder){
        System.out.println("Checking out!");
    }

    private void createNewOrder() {
        currentOrder = new Order();
    }

    private void cancelOrder() {
        currentOrder = null;
        System.out.println("==============================================================");
        System.out.println("\nOrder canceled!\n");
    }
}
