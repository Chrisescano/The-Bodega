package org.pluralsight.shop;

import java.util.Scanner;

public class OrderScreen {

    protected void displayOrderScreen() {

        Scanner scanner = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            System.out.printf("""
                    Order Menu
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    5) Cancel Order 
                    \n
                    """);

            System.out.println("Select the operation type by typing its number below: ");
            int input = scanner.nextInt();
            System.out.println();

            switch (input) {
                case 1 -> addSandwich();
                case 2 -> addDrink();
                case 3 -> addChips();
                case 4 -> {
                    checkout();
                    done = true;
                }
                case 5 -> {
                    cancelOrder();
                    done = true;
                }
                default -> System.out.println("please select again \n");
            }
        }
    }

    private void addSandwich() {
        System.out.println("Displaying addSandwich method \n");
    }

    private void addDrink() {
        System.out.println("Displaying addDrink method \n");
    }

    private void addChips() {
        System.out.println("Displaying addChips method \n");
    }

    private void checkout() {
        System.out.println("Displaying checkout method \n");
    }

    private void cancelOrder() {
        System.out.println("Displaying cancelOrder method \n");
    }

}