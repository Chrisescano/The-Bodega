package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuItems.Sandwich;
import org.pluralsight.shop.Order;

public class OrderScreen implements Displayable {
    Order order;
    SandwichScreen sandwichScreen;
    DrinksScreen drinksScreen;
    ChipsScreen chipsScreen;
    CheckoutScreen checkoutScreen;

    public OrderScreen() {
        order = new Order();
        sandwichScreen = new SandwichScreen(order);
        drinksScreen = new DrinksScreen(order);
        chipsScreen = new ChipsScreen(order);
        checkoutScreen = new CheckoutScreen(order);
    }

    @Override
    public void screen() {
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
            screen();
            int userInput = ScannerIO.getIntInput("Enter Your Command: ");
            switch (userInput) {
                case 1 -> sandwichScreen.run();
                case 2 -> drinksScreen.run();
                case 3 -> chipsScreen.run();
                case 4 -> {
                    checkoutScreen.run();
                    return;
                }
                case 0 -> { return; }
                default -> System.out.println("Sorry, "+ userInput +" Is Not A Valid Command. Try Again");
            }
        }
    }
}