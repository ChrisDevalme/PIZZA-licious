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

            switch (userChoice) {
                case "1":
                    processNewOrder();
                    break;
                case "0":
                    quit = true;
                default:
                    System.out.println("\nInvalid input. Please enter 1 or 0.\n");
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
                            " 0) Cancel Order\n" +
                            "Your choice:"
            );
            String userChoice = scanner.nextLine();
            if (!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3") && !userChoice.equals("4")
            && !userChoice.equals("0")) {
                System.out.println("Invalid input.");
                continue;
            };

            switch (userChoice){
                case "1":
                    processAddPizza();
                    break;
                case "2":
                    processAddDrink();
                    break;
                case "3":
                    processAddGarlicKnots();
                    break;
                case "4":
                    processCheckout();
                    break;
                case "0":
                    ordering = false;
                    cancelOrder();
                    break;
                default:
                    System.out.println("Invalid input. Please enter 0-4.");
            }
        }
    }
    public void processAddPizza(){
        System.out.println("Adding pizza!");
    }
    public void processAddDrink() {
        System.out.println("Adding Drink!");
    }
    public void processAddGarlicKnots() {
        System.out.println("Adding Garlic Knots!");
    }
    public void processCheckout(){
        System.out.println("Checking out!");
    }

    private void createNewOrder() {
        currentOrder = new Order();
        priintOrder();
    }

    private void cancelOrder() {
        currentOrder = null;
        System.out.println("==============================================================");
        System.out.println("\nOrder canceled!\n");
    }

    public void priintOrder() {
        if(!currentOrder.getItems().isEmpty()) {
            System.out.println("======================= Order ======================= ");
            currentOrder.getItems().forEach(System.out::println);
        } else {
            System.out.println("======================= Order ======================= ");
            System.out.println("                      ( Emtpy )                         ");
        }
    }
}
