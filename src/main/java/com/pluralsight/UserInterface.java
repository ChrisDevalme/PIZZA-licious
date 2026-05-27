package com.pluralsight;

import com.pluralsight.model.Order;
import com.pluralsight.model.Pizza;
import com.pluralsight.model.topping.CheeseTopping;
import com.pluralsight.model.topping.MeatTopping;
import com.pluralsight.model.topping.PremiumTopping;
import com.pluralsight.service.ReceiptService;

import java.util.List;
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
                    "[1] New Order\n" +
                    "[0] Exit\n" +
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
                        "[1] Add Pizza\n" +
                        "[2] Add Drink\n" +
                        "[3] Add Garlic Knots\n" +
                        "[4] Checkout\n" +
                        "[0] Cancel Order\n" +
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
        pickPizzaMeats(pizza);
        pickPizzaCheese(pizza);
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

    private void pickPizzaSize(Pizza pizza) {
        boolean ordering = true;

        while(ordering) {
            System.out.println(" -----------------------[ SIZE ]-----------------------");
            System.out.println("[1] Personal 8\"  — $8.50");
            System.out.println("[2] Medium  12\" — $12.00");
            System.out.println("[3] Large   16\" — $16.50");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();
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
                    break;
            }
        }
    }
    private void pickPizzaCrust(Pizza pizza) {

        boolean ordering = true;

        while(ordering) {
            System.out.println("\n -----------------------[ CRUST ]-----------------------");
            System.out.println("[1] Thin");
            System.out.println("[2] Regular");
            System.out.println("[3] Thick");
            System.out.println("[4] Cauliflower");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();
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
                default: System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }
    private void pickPizzaMeats(Pizza pizza) {
        List<MeatTopping> meats = MeatTopping.getAll();

        boolean ordering = true;
        MeatTopping selected;

        while(ordering) {
            System.out.println("\n -----------------------[ MEATS ]-----------------------");
            System.out.println("[0] Skip Meats/Done adding Meats");
            System.out.println("[1] Pepperoni");
            System.out.println("[2] Sausage");
            System.out.println("[3] Ham");
            System.out.println("[4] Bacon");
            System.out.println("[5] Chicken");
            System.out.println("[6] Meatball");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "0":
                    return;

                case "1":
                    selected = meats.get(0); // Pepperoni
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "2":
                    selected = meats.get(1); // Sausage
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "3":
                    selected = meats.get(2); // Ham
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "4":
                    selected = meats.get(3); // Bacon
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "5":
                    selected = meats.get(4); // Chicken
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "6":
                    selected = meats.get(5); // Meatball
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                default:
                    System.out.println("Invalid choice entry must be 0 - 6.\n");
            }
        }
    }
    private void pickPizzaCheese(Pizza pizza) {
        List<CheeseTopping> cheese = CheeseTopping.getAll();

        boolean ordering = true;
        CheeseTopping selected;

        while(ordering) {
            System.out.println("\n -----------------------[ CHEESES ]-----------------------");
            System.out.println("[0] Skip Cheese/Done adding Cheese");
            System.out.println("[1] Mozzarella");
            System.out.println("[2] Parmesan");
            System.out.println("[3] Ricotta");
            System.out.println("[4] Goat Cheese");
            System.out.println("[5] Buffalo");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "0":
                    return;

                case "1":
                    selected = cheese.get(0); // Mozzarella
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "2":
                    selected = cheese.get(1); // Parmesan
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "3":
                    selected = cheese.get(2); // Ricotta
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "4":
                    selected = cheese.get(3); // Goat Cheese
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;

                case "5":
                    selected = cheese.get(4); // Buffalo
                    ordering = addPremiumToppingExtraPrompt(pizza, selected);
                    break;
                default:
                    System.out.println("Invalid choice entry must be 0 - 6.\n");
            }
        }
    }
    private boolean addPremiumToppingExtraPrompt(Pizza pizza, PremiumTopping selected) {
        boolean validExtra = false;
        while (!validExtra) {
            System.out.println("Extra " + selected.getName() + "? \n [1] Yes  \n [0] No");
            System.out.print("Your choice: ");
            String extraChoice = scanner.nextLine();

            switch (extraChoice) {
                case "1":
                    selected.setExtra(true);
                    validExtra = true;
                    break;
                case "0":
                    selected.setExtra(false);
                    validExtra = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1 or 0.\n");
            }
        }
        pizza.addTopping(selected);
        System.out.println("Added: " + selected.getName() + (selected.isExtra() ? " + (extra)" : " - (Single Serving)"));

        boolean validMore = false;
        while (!validMore) {
            System.out.println("\nAdd another? \n [1] Yes  \n [0] No");
            System.out.print("Your choice: ");
            String addMore = scanner.nextLine().trim();

            switch (addMore) {
                case "1":
                    validMore = true;
                    return true;
                case "0":
                    validMore = true;
                    return false;
                default:
                    System.out.println("Invalid input. Please enter 1 or 0.");
            }
        }
        return false;
    }

}
