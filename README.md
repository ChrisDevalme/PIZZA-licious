# Project Title: PIZZALICIOUS CLI Ordering System

## Description of the Project

PIZZALICIOUS is a Java-based command-line pizza ordering application that allows customers to fully customize food orders through an interactive menu-driven interface. Users can build custom pizzas with multiple crusts, toppings, sauces, stuffed crust options, drinks, and garlic knots while receiving real-time pricing updates based on their selections. Once checkout is complete, the application generates and saves a formatted receipt file locally with the full order summary and total cost.

The project was designed with a strong focus on object-oriented programming principles such as abstraction, inheritance, interfaces, composition, and separation of concerns. The system uses a scalable architecture that makes it easy to extend with future features such as databases, delivery systems, online ordering, or graphical interfaces.

---

# Features

## Ordering System

* Create a new order
* Cancel an order
* Checkout and confirm orders
* View live order summary while ordering

## Pizza Customization

* Multiple pizza sizes
* Multiple crust styles
* Stuffed crust option
* Premium toppings with extra serving option
* Regular toppings
* Sauces and side toppings
* Dynamic pizza pricing calculation

## Additional Menu Items

* Drinks with multiple sizes and flavors
* Garlic knots with different counts and flavors

## Receipt System

* Automatically creates receipt files
* Timestamped receipt naming
* Formatted order summaries
* Saves receipts locally inside a receipts folder

---

# User Stories

* As a user, I want to create a new order so that I can begin building my meal.
* As a user, I want to customize my pizza so that I can choose the exact toppings and crust I want.
* As a user, I want to add premium toppings so that I can create specialty pizzas.
* As a user, I want to choose extra portions of toppings so that I can customize the amount added to my pizza.
* As a user, I want to add drinks and garlic knots so that I can complete my meal.
* As a user, I want to see my order summary while ordering so that I can review my selections before checkout.
* As a user, I want to checkout and save my receipt so that I can keep a record of my order.
* As a user, I want to cancel my order so that I can restart or exit the application.

---

# Setup

## Prerequisites

* Java 17
* IntelliJ IDEA
* Git (optional if cloning from GitHub)

---

# Running the Application in IntelliJ

1. Open IntelliJ IDEA.
2. Select **Open** and navigate to the project folder.
3. Wait for IntelliJ to finish indexing the project.
4. Open the `Main.java` file.
5. Right-click the file and select:
   `Run Main.main()`

---

# Technologies Used

* Java 17

---

## Demo


![May-28-2026 14-22-02.gif](assets/May-28-2026%2014-22-02.gif)
# Project Structure

```text
com.pluralsight
├── Main.java
├── ui
│   └── UserInterface.java
├── model
│   ├── Order.java
│   ├── OrderItem.java
│   ├── Pizza.java
│   ├── Drink.java
│   ├── GarlicKnots.java
│   ├── signature
│   │   ├── MargheritaPizza.java
│   │   └── VeggiePizza.java
│   └── topping
│       ├── Topping.java
│       ├── PremiumTopping.java
│       ├── MeatTopping.java
│       ├── CheeseTopping.java
│       ├── RegularTopping.java
│       ├── SauceTopping.java
│       └── SideTopping.java
└── service
    └── ReceiptService.java
```

---

# Object-Oriented Programming Concepts Used

## Interfaces

The `OrderItem` interface allows pizzas, drinks, and garlic knots to behave uniformly inside an order.

## Inheritance

The topping system uses inheritance to group premium and regular toppings while reducing duplicated pricing logic.

## Composition

Pizzas are composed of multiple toppings stored inside collections.

## Polymorphism

The order system stores all products using `List<OrderItem>` and dynamically calls pricing methods depending on the item type.

---

# Future Improvements

* Signature pizzas
* Delivery system
* Database integration
* User accounts
* GUI or web frontend
* Online ordering system
* Inventory management
* Admin dashboard

---

# Resources

* Java Documentation
* IntelliJ IDEA Documentation
* Java File I/O Documentation
* Java Collections Framework Documentation
* Class workshops and notes

---

# Team Members

* **Christopher Devalme** — Designed and built the full PIZZALICIOUS ordering system including architecture, ordering flow, pricing logic, toppings system, and receipt persistence.

---

# Thanks

* Thank you to Raymond Maroun for continuous support and guidance throughout the project.
* Thank you to classmates and peers for feedback and collaboration during development.
