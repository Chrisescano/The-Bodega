package org.pluralsight.shop;

import java.util.Scanner;

public class HomeScreen {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        displayHomeScreen();
    }

    private static void displayHomeScreen() {
        boolean done = false;
        while (!done) {
            System.out.printf("""
                    Home Menu
                    1) New Order
                    0) Exit
                    \n """);

            System.out.println("Select the operation type by typing its number below: ");
            int input = scanner.nextInt();
            System.out.println();

            switch (input) {
                case 1 -> newOrder();
                case 0 -> {
                    System.out.println("Thank you for visiting The Bodega");
                    done = true;
                }
                default -> System.out.println("please select again \n");
            }
        }
    }

    private static void newOrder() {
        OrderScreen orderScreen = new OrderScreen();
        orderScreen.displayOrderScreen();
    }

}