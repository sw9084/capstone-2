package com.pluralsight.pizzalicious;

import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Order order = new Order();
    // the main method entry point of the application

    public static void main(String[] args) {
        displayWelcomeMessage();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        collectCustomerInfo();
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
                case 3:
                    addPizza();
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
        System.out.println("║            🍕  Welcome to PizzaLicious              🍕║");
        System.out.println("║         Your Custom Pizza and Drink Experience      ║");
        System.out.println("╚═════════════════════════════════════════════════════╝");
    }

    //--------------Customer info method-------------------
    private static void collectCustomerInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n👤═══════════ CUSTOMER INFORMATION ═══════════");
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();

        System.out.println("Delivery or pick up? (D/P): ");
        String type = scanner.nextLine().trim().toUpperCase();

        boolean isDelivery = type.equals("D");
        String address = " ";

        if (isDelivery) {
            System.out.println("Enter delivery address: ");
            address = scanner.nextLine();
        }
        Customer customer = new Customer(name, phone, isDelivery, address);
        order.setCustomer(customer);
        System.out.println("\n✅Customer added successfully!");
    }


    //--------------Main Menu------------------------


    private static void displayMainMenu() {
        System.out.println("\n     Main Menu     ");
        System.out.println("════════════════════════");
        System.out.println("1️⃣ Add a Drink");
        System.out.println("2️⃣ Checkout");
        System.out.println("3️⃣ Add a Pizza");
        System.out.println("0️⃣  Exit");
        System.out.println("═════════════════════════");
    }
    //----------Add Drink-----------------------------


    private static void addDrink() {
        System.out.print("Please enter drink flavor: ");
        String flavor = scanner.nextLine();
        System.out.print("Enter size (S/ M/ L): ");
        String sizeChoice = scanner.nextLine().trim().toUpperCase();
        String size;
        switch (sizeChoice) {
            case "S":
                size = "Small";
                break;
            case "M":
                size = "Medium";
                break;
            case "L":
                size = "Large";
                break;
            default:
                System.out.println("Invalid choice. defaulting to medium. ");
                size = "Medium";

        }

        Drink drink = new Drink(flavor, size);
        order.addDrink(drink);

        System.out.println(" ✅ " + size + " " + flavor + " added to your order!");


    }

    private static void addPizza() {
        System.out.println("\n═════════ Build Your Pizza ═══════");
        System.out.println("S - Small");
        System.out.println("M - Medium");
        System.out.println("L - Large");
        System.out.println("Enter choice: ");

        String sizeChoice = scanner.nextLine().trim().toUpperCase();
        String size;
        switch (sizeChoice) {
            case "S":
                size = "small";
                break;
            case "M":
                size = "medium";
                break;

            case "L":
                size = "large";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to medium. ");
                size = "medium";
        }

        System.out.println("Choose Crust:");
        System.out.println("T - Thin");
        System.out.println("R - Regular");
        System.out.println("K - Thick");
        System.out.println("Enter crust");

        String crustChoice = scanner.nextLine().trim().toUpperCase();
        String crust;
        switch (crustChoice) {
            case "T":
                crust = "thin";
                break;
            case "R":
                crust = "regular";
                break;
            case "K":
                crust = "thick";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to regular crust");
                crust = "regular";
        }

        System.out.println("Stuffed crust? (Y/N): ");
        String stuffedInput = scanner.nextLine().trim().toUpperCase();
        boolean stuffed = stuffedInput.equals("Y");

        //--------Create base pizza---------
        Pizza pizza = new Pizza(size, crust, stuffed);
        //--------Add topping---------------
        System.out.println("How many topping? ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("\nChoose topping: ");
            System.out.println("1️⃣ Sausage");
            System.out.println("2️⃣ Pepperoni");
            System.out.println("3️⃣ Mushroom");
            System.out.println("4️⃣ Olives");
            System.out.println("Enter choice: ");

            int toppingChoice = scanner.nextInt();
            scanner.nextLine();

            String name = "";
            switch (toppingChoice) {
                case 1:
                    name = "Sausage";
                    break;
                case 2:
                    name = "Pepperoni";
                    break;
                case 3:
                    name = "Mushroom";
                    break;
                case 4:
                    name = "Olives";
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to cheese.");
                    name = "Cheese";
            }
            System.out.println("\nChoose category:");
            System.out.println("1. meat");
            System.out.println("2. non-meat");
            System.out.println(("Enter choice:"));

            int categoryChoice = scanner.nextInt();
            scanner.nextLine();

            String category = (categoryChoice == 1) ? "meat" : "non-meat";

            System.out.println("Extra portion? (Y/N): ");
            String extraInput = scanner.nextLine().trim().toUpperCase();
            boolean extra = extraInput.equals("Y");

            Topping topping = new Topping(name, category, extra);
            pizza.addTopping(topping);
        }
        order.addPizza(pizza);

        System.out.println("\n✅ Pizza added successfully!");
        System.out.println(pizza.getDescription());
    }
    //------------------Checkout---------------------------

    private static void checkout() {
        System.out.println("\n═══════════Checkout Summary═════════ ");


    }
}




