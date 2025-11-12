package com.pluralsight.pizzalicious;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Order order = new Order();
    // the main method entry point of the application

    public static void main(String[] args) {
        displayWelcomeMessage();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        runProgram();
    }

    private static void runProgram() {
        int choice;
        do {
            displayMainMenu();
            System.out.print("Please enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. please enter a number (0, 1, or 2). ");
                System.out.println("Enter your choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDrink();
                    break;
                case 2:
                    checkout();
                    break;
                case 0:
                    System.out.println("\n❤️ Thank you for visiting PizzaLicious! ");
                    System.out.println("Have a great day!");
                    break;
                default:
                    System.out.println(" ⚠️ Invalid choice. Please try again. ");
            }
        } while (choice != 0);
    }

    private static void displayWelcomeMessage() {
        System.out.println("╔═════════════════════════════════════════════════════╗");
        System.out.println("║            🍕  Welcome to PizzaLicious              🍕  ║");
        System.out.println("║    Your Custom Pizza and Drink Experience           ║");
        System.out.println("╚═════════════════════════════════════════════════════╝");
        {

        }

    }

    private static void displayMainMenu() {
        System.out.println("\n     Main Menu     ");
        System.out.println("════════════════════════");
        System.out.println("1️⃣ Add a Drink");
        System.out.println("2️⃣ Checkout");
        System.out.println("0️⃣  Exit");
        System.out.println("═════════════════════════");
    }

    private static void addDrink() {
        System.out.print("Please enter drink flavor: ");
        String flavor = scanner.nextLine();
        System.out.print("Enter size (Small / Medium / large): ");
        String size = scanner.nextLine();
        Drink drink = new Drink(flavor, size);
        order.addDrink(drink);

        System.out.println(" ✅ " + size + " " + flavor + " added to your order!");

    }


    private static void checkout() {
        System.out.println("\n═══════════Checkout Summary═════════ ");

        //Quick Test for pizza and topping
    Topping cheese = new Topping("Cheese", "non-meat", false);
    Topping pepperoni = new Topping("pepperoni","meat", false);
    Topping extraCheese = new Topping("Extra cheese", "non-meat", true);
    // create pizza with base setting
    Pizza pizza = new Pizza("Medium", "regular", true, 10.00);
    pizza.addTopping(cheese);
    pizza.addTopping(pepperoni);
    pizza.addTopping(extraCheese);


        System.out.println(pizza.getDescription());

    }
}




