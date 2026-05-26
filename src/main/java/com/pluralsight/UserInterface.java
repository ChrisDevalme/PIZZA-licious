package com.pluralsight;

import com.pluralsight.model.Order;
import com.pluralsight.model.Pizza;
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
            printOrder();
            printOrderMenu();
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

    private static void printOrderMenu() {
        System.out.println(
                "=====================  Order Menu =====================\n" +
                        " 1) Add Pizza\n" +
                        " 2) Add Drink\n" +
                        " 3) Add Garlic Knots\n" +
                        " 4) Checkout\n" +
                        " 0) Cancel Order\n" +
                        "Your choice:"
        );
    }

    public void processAddPizza(){
        System.out.println("\n  ┌─────────────────────────────┐");
        System.out.println(  "        BUILD YOUR PIZZA 🍕      ");
        System.out.println(  "  └─────────────────────────────┘\n");

        Pizza pizza = new Pizza();

        pickPizzaSize(pizza);
        pickPizzaCrust(pizza);
//        pickMeats(pizza);
//        pickCheeses(pizza);
//        pickRegularToppings(pizza);
//        pickSauces(pizza);
//        pickSides(pizza);
//        pizza.setStuffedCrust(pickStuffedCrust());

        currentOrder.addItem(pizza);
        System.out.println("\n  Pizza added to your order!\n");
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
    }

    private void cancelOrder() {
        currentOrder = null;
        System.out.println("==============================================================");
        System.out.println("\nOrder canceled!\n");
    }

    public void printOrder() {
        if(!currentOrder.getItems().isEmpty()) {
            System.out.println("======================= Order ======================= ");
            currentOrder.getItems().forEach(System.out::println);
        } else {
            System.out.println("======================= Order ======================= ");
            System.out.println("                      ( Emtpy )                         ");
        }
    }

    private String pickPizzaSize(Pizza pizza) {
        System.out.println(" -----------------------[ SIZE ]-----------------------");
        System.out.println("  [1] Personal 8\"  — $8.50");
        System.out.println("  [2] Medium  12\" — $12.00");
        System.out.println("  [3] Large   16\" — $16.50");
        System.out.print("  Your choice: ");
        boolean ordering = true;

        String choice = scanner.nextLine();

        while(ordering) {
            switch (choice) {
                case "1":
                    pizza.setSize("8");
                    ordering = false;
                    break;
                case "2":
                    pizza.setSize("12");
                    ordering = false;
                    break;
                case "3":
                    pizza.setSize("16");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid Choice, enter an entry between 1 - 3");
            }
        }
            return choice;
    }
    private String pickPizzaCrust(Pizza pizza) {
        System.out.println("\n -----------------------[ CRUST ]-----------------------");
        System.out.println("  [1] Thin");
        System.out.println("  [2] Regular");
        System.out.println("  [3] Thick");
        System.out.println("  [4] Cauliflower");
        System.out.print("  Your choice: ");
        String choice = scanner.nextLine();
        boolean ordering = true;

        while(ordering) {
            switch (choice) {
                case "1":
                    pizza.setCrust("Thin");
                    ordering = false;
                    break;
                case "2":
                    pizza.setCrust("Regular");
                    ordering = false;
                    break;
                case "3":
                    pizza.setCrust("Thick");
                    ordering = false;
                    break;
                case "4":
                    pizza.setCrust("Cauliflower");
                    ordering = false;
                    break;
                default: System.out.println("  Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
        return choice;
    }
}
