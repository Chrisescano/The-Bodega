package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.shop.Order;

public class OrderScreen implements Displayable {
    //Order order;

    public OrderScreen() {
        //order = new Order();
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
                case 1 -> {
                    //SandwichScreen sandwichScreen = new SandwichScreen(order);
                    //sandwichScreen.run();
                }
                case 2 -> System.out.println("Order A Drink");
                case 3 -> System.out.println("Order A Chip");
                case 4 -> {
                    //CheckoutScreen checkoutScreen = new CheckoutScreen(order);
                    //checkoutScreen.run();
                    //return;
                }
                case 0 -> { return; }
                default -> System.out.println("Sorry, "+ userInput +" Is Not A Valid Command. Try Again");
            }
        }
    }
}