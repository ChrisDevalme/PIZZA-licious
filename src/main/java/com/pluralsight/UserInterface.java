package com.pluralsight;

import com.pluralsight.model.*;
import com.pluralsight.model.products.Drink;
import com.pluralsight.model.products.GarlicKnots;
import com.pluralsight.model.products.Pizza;
import com.pluralsight.model.topping.*;
import com.pluralsight.model.topping.premiumTopping.CheeseTopping;
import com.pluralsight.model.topping.premiumTopping.MeatTopping;
import com.pluralsight.model.topping.premiumTopping.PremiumTopping;
import com.pluralsight.model.topping.regularTopping.RegularTopping;
import com.pluralsight.model.topping.regularTopping.SauceTopping;
import com.pluralsight.model.topping.regularTopping.SideTopping;
import com.pluralsight.service.ReceiptService;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order currentOrder;

    public UserInterface(){
        scanner = new Scanner(System.in);
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

    // Order Logic
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
                    ordering = false;
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
    private void createNewOrder() {
        currentOrder = new Order();
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
    private void cancelOrder() {
        currentOrder = null;
        System.out.println("\nOrder canceled!\n");
        System.out.println("==============================================================");
    }
    private void printOrderSummary() {
        List<OrderItem> items = currentOrder.getItems();

        System.out.println("\n  ╔══════════════════════════════════════╗");
        System.out.println(  "  ║         ORDER SUMMARY                ║");
        System.out.println(  "  ╠══════════════════════════════════════╣\n");

        if (items.isEmpty()) {
            System.out.println("  ║  ( empty )                           ║");
        } else {
            for (int i = items.size() - 1; i >= 0; i--) {
                OrderItem item = items.get(i);
                System.out.printf("%s %n", item.toString());

            }
        }

        System.out.println("\n  ╠══════════════════════════════════════╣");
        System.out.printf( "  ║  %-28s $%5.2f ║%n", "TOTAL", currentOrder.calculateTotal());
        System.out.println("  ╚══════════════════════════════════════╝\n");
    }
    private void confirmOrder() {
        ReceiptService recipt = new ReceiptService();
        recipt.saveReceipt(currentOrder);

        System.out.println("  ╔══════════════════════════════════════╗");
        System.out.println("  ║       ORDER CONFIRMED!  🍕           ║");
        System.out.println("  ║   Your receipt has been saved.       ║");
        System.out.println("  ║   Thanks for ordering PIZZALICIOUS!  ║");
        System.out.println("  ╚══════════════════════════════════════╝\n");

        currentOrder = null;
    }
    private void processCheckout() {

        printOrderSummary();

        boolean valid = false;
        while (!valid) {
            System.out.println("[1] Confirm Order");
            System.out.println("[0] Cancel Order");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    confirmOrder();
                    valid = true;
                    break;
                case "0":
                    cancelOrder();
                    valid = true;
                    break;
                default:
                    System.out.println(" Invalid input. Please enter 1 or 0. \n");
            }
        }
    }

    // Pizza Order Logic
    public void processAddPizza(){
        System.out.println("\n  ┌─────────────────────────────┐");
        System.out.println(  "        BUILD YOUR PIZZA 🍕      ");
        System.out.println(  "  └─────────────────────────────┘\n");

        Pizza pizza = new Pizza();

        pickPizzaSize(pizza);
        pickPizzaCrust(pizza);
        pickPizzaMeats(pizza);
        pickPizzaCheese(pizza);
        pickRegularToppings(pizza);
        pickSauces(pizza);
        pickSides(pizza);
        pickStuffedCrust(pizza);

        currentOrder.addItem(pizza);
        System.out.println("\nPizza added to your order!\n");
    }
    private void pickPizzaSize(Pizza pizza) {
        boolean ordering = true;

        while(ordering) {
            System.out.println(" -----------------------[ SIZE ]-----------------------");
            System.out.println("[1] Personal 8\" — $8.50");
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
            System.out.println("                       Prices by size:");
            System.out.println("            8\"  - Regular: $1.00 | Extra: +$0.50");
            System.out.println("            12\" - Regular: $2.00 | Extra: +$1.00");
            System.out.println("            16\" - Regular: $3.00 | Extra: +$1.50\n");
            System.out.println("[0] Done adding Meats");
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
            System.out.println("                       Prices by size:");
            System.out.println("           8\"  - Regular: $0.75 | Extra: +$0.30");
            System.out.println("           12\" - Regular: $1.50 | Extra: +$0.60");
            System.out.println("           16\" - Regular: $2.25 | Extra: +$0.90\n");
            System.out.println("[0] Done adding Cheese");
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
    private void pickRegularToppings(Pizza pizza) {
        List<RegularTopping> options = RegularTopping.getAll();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n -----------------------[ REGULAR TOPPINGS ]----------------------");
            System.out.println("[0] Done adding Toppings");
            System.out.println("[1] Onions");
            System.out.println("[2] Mushrooms");
            System.out.println("[3] Bell Peppers");
            System.out.println("[4] Olives");
            System.out.println("[5] Tomatoes");
            System.out.println("[6] Spinach");
            System.out.println("[7] Basil");
            System.out.println("[8] Pineapple");
            System.out.println("[9] Anchovies");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "0": ordering = false; break;
                case "1": ordering = addFreeToppingPrompt(pizza, options.get(0));  break; // Onions
                case "2": ordering = addFreeToppingPrompt(pizza, options.get(1));  break; // Mushrooms
                case "3": ordering = addFreeToppingPrompt(pizza, options.get(2));  break; // Bell Peppers
                case "4": ordering = addFreeToppingPrompt(pizza, options.get(3));  break; // Olives
                case "5": ordering = addFreeToppingPrompt(pizza, options.get(4));  break; // Tomatoes
                case "6": ordering = addFreeToppingPrompt(pizza, options.get(5));  break; // Spinach
                case "7": ordering = addFreeToppingPrompt(pizza, options.get(6));  break; // Basil
                case "8": ordering = addFreeToppingPrompt(pizza, options.get(7));  break; // Pineapple
                case "9": ordering = addFreeToppingPrompt(pizza, options.get(8));  break; // Anchovies
                default: System.out.println("  Invalid choice — try again.");
            }
        }
    }
    private void pickSauces(Pizza pizza) {
        List<SauceTopping> options = SauceTopping.getAll();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n -----------------------[ SAUCES ]----------------------");
            System.out.println("[0] Done adding Sauces");
            System.out.println("[1] Marinara");
            System.out.println("[2] Alfredo");
            System.out.println("[3] Pesto");
            System.out.println("[4] BBQ");
            System.out.println("[5] Buffalo");
            System.out.println("[6] Olive Oil");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "0": ordering = false; break;
                case "1": ordering = addFreeToppingPrompt(pizza, options.get(0)); break;
                case "2": ordering = addFreeToppingPrompt(pizza, options.get(1)); break;
                case "3": ordering = addFreeToppingPrompt(pizza, options.get(2)); break;
                case "4": ordering = addFreeToppingPrompt(pizza, options.get(3)); break;
                case "5": ordering = addFreeToppingPrompt(pizza, options.get(4)); break;
                case "6": ordering = addFreeToppingPrompt(pizza, options.get(5)); break;
                default: System.out.println("  Invalid choice — try again.");
            }
        }
    }
    private void pickSides(Pizza pizza) {
        List<SideTopping> options = SideTopping.getAll();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n -----------------------[ SIDES ]----------------------");
            System.out.println("[0] Done adding Sides");
            System.out.println("[1] Red Pepper");
            System.out.println("[2] Parmesan");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "0": ordering = false; break;
                case "1": ordering = addFreeToppingPrompt(pizza, options.get(0)); break;
                case "2": ordering = addFreeToppingPrompt(pizza, options.get(1)); break;
                default: System.out.println("Invalid choice — try again.");
            }
        }
    }
    private void pickStuffedCrust(Pizza pizza) {
        boolean ordering  = true;

        while (ordering) {
            System.out.println("\n -----------------------[ STUFFED CRUST ]----------------------");
            System.out.println("Would you like to add stuffed crust? \n[1] Yes \n[0] No");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "0": ordering = false; break;
                case "1":
                    pizza.setStuffedCrust(true);
                    System.out.println("✓ Added Stuffed Crust to Pizza");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid Choice, enter 0 or 1.");
            }
        }
    }
    private boolean addFreeToppingPrompt(Pizza pizza, Topping selected) {

        pizza.addTopping(selected);
        System.out.println("✓ Added: " + selected.getName());


        boolean validMore = false;
        while (!validMore) {
            System.out.println("\nAdd another? [1] Yes  [0] No");
            System.out.print("Your choice: ");
            String moreToppings = scanner.nextLine().trim();

            switch (moreToppings) {
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
    private boolean addPremiumToppingExtraPrompt(Pizza pizza, PremiumTopping selected) {
        boolean validExtra = false;
        while (!validExtra) {
            System.out.println("Extra " + selected.getName() + "? \n[1] Yes  \n[0] No");
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
            System.out.println("\nAdd another? \n[1] Yes  \n[0] No");
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

    // Drink Order Logic
    public void processAddDrink() {
        Drink drink = new Drink();
        pickDrinkSize(drink);
        pickDrinkFlavor(drink);

        currentOrder.addItem(drink);
    }
    public void pickDrinkSize(Drink drink) {
        boolean ordering = true;

        while (ordering) {

            System.out.println(" -----------------------[ DRINKS ]-----------------------");
            System.out.println("Select Size: ");
            System.out.println("[1] Small - $2.00");
            System.out.println("[2] Medium - $2.50");
            System.out.println("[3] Large - $3.00");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch(choice){
                case "1" :
                    drink.setSize("Small");
                    ordering = false;
                    break;
                case "2" :
                    drink.setSize("Medium");
                    ordering = false;
                    break;
                case "3" :
                    drink.setSize("Large");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid input. Enter a number between 1 - 3.");
            }

        }
    }
    public void pickDrinkFlavor(Drink drink) {
        boolean ordering = true;

        while (ordering) {

            System.out.println(" -----------------------[ DRINK FLAVORS]-----------------------");
            System.out.println("Select Flavor: ");
            System.out.println("[0] Cancel");
            System.out.println("[1] Water");
            System.out.println("[2] Coke");
            System.out.println("[3] Pepsi");
            System.out.println("[4] Fanta");
            System.out.println("[5] Dr.Pepper");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch(choice){
                case "0" :
                    ordering = false;
                    break;
                case "1" :
                    drink.setFlavor("Water");
                    ordering = false;
                    break;
                case "2" :
                    drink.setFlavor("Coke");
                    ordering = false;
                    break;
                case "3" :
                    drink.setFlavor("Pepsi");
                    ordering = false;
                    break;
                case "4" :
                    drink.setFlavor("Fanta");
                    ordering = false;
                    break;
                case "5" :
                    drink.setFlavor("Dr.Pepper");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid input. Enter a number between 0 - 5.");
            }

        }

    }

    // Garlic Knot Order Logic
    public void processAddGarlicKnots() {
        GarlicKnots gKnots = new GarlicKnots();
        pickGarlicKnotsCount(gKnots);
        pickGarlicKnotsFlavor(gKnots);
        currentOrder.addItem(gKnots);
    }
    public void pickGarlicKnotsCount(GarlicKnots gKnots) {
        boolean ordering = true;

        while (ordering) {

            System.out.println(" -----------------------[ DRINKS ]-----------------------");
            System.out.println("Select Size: ");
            System.out.println("[1] 6 Count");
            System.out.println("[2] 12 Count");
            System.out.println("[3] 16 Count");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch(choice){
                case "1" :
                    gKnots.setCount("6");
                    ordering = false;
                    break;
                case "2" :
                    gKnots.setCount("12");
                    ordering = false;
                    break;
                case "3" :
                    gKnots.setCount("18");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid input. Enter a number between 1 - 3.");
            }
        }
    }
    public void pickGarlicKnotsFlavor(GarlicKnots gKnot) {
        boolean ordering = true;
        while(ordering) {
            System.out.println("-----------------------[ GARLIC KNOT FLAVORS ]-----------------------");
            System.out.println("[0] Plain");
            System.out.println("[1] Original Garlic Butter");
            System.out.println("[2] Garlic Parmesan");
            System.out.println("[3] Spicy Garlic");
            System.out.println("[4] Garlic Ranch");
            System.out.println("[5] Buffalo Garlic");
            System.out.println("[6] Honey Garlic");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "0":
                    ordering = false;
                    gKnot.setFlavor("Plain");
                    break;
                case "1":
                    gKnot.setFlavor("Original Garlic Butter");
                    ordering = false;
                    break;
                case "2":
                    gKnot.setFlavor("Garlic Parmesan");
                    ordering = false;
                    break;
                case "3":
                    gKnot.setFlavor("Spicy Garlic");
                    ordering = false;
                    break;
                case "4":
                    gKnot.setFlavor("Garlic Ranch");
                    ordering = false;
                    break;
                case "5":
                    gKnot.setFlavor("Buffalo Garlic");
                    ordering = false;
                    break;
                case "6":
                    gKnot.setFlavor("Honey Garlic");
                    ordering = false;
                    break;
                default:
                    System.out.println("  Invalid choice. Please enter 0-6.");
            }

        }

    }

}
