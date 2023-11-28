package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;

import java.util.Scanner;
import java.util.SortedMap;

public class OrderScreen implements Displayable {



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

    @Override
    public void display() {
        System.out.print("""
                You Can Add The Following To Your Order
                  (1) - Add Sandwich
                  (2) - Add Drink
                  (3) - Add Chips
                  (4) - Checkout
                  (0) - Cancel Order
                  
                """);
    }

    @Override
    public void run() {
        while (true) {
            display();
            int userInput = ScannerIO.getIntInput("Enter Your Command: ");
            switch (userInput) {
                case 1 -> System.out.println("Order A Sandwich");
                case 2 -> System.out.println("Order A Drink");
                case 3 -> System.out.println("Order A Chip");
                case 4 -> System.out.println("Checkout");
                case 0 -> { return; }
                default -> System.out.println("Sorry, "+ userInput +" Is Not A Valid Command. Try Again");
            }
        }
    }
}