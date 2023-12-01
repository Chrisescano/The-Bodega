package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuItems.ItemManager;
import org.pluralsight.menuItems.Sandwich;
import org.pluralsight.shop.Order;
import org.pluralsight.shop.Size;
import org.pluralsight.topping.Topping;
import org.pluralsight.util.MenuTable;

import java.util.ArrayList;

public class SandwichScreen implements Displayable{
    Order order;
    MenuTable menuTable;
    ItemManager itemManager;
    Sandwich sandwich;

    SandwichScreen(Order order) {
        this.order = order;
        menuTable = new MenuTable("sandwiches");
        itemManager = new ItemManager();
    }

    @Override
    public void screen() {
        System.out.print("""
                
                Here Is A Menu Of All Our Sandwiches
                """);
        menuTable.run();
    }

    @Override
    public void run() {
        screen();
        validateSandwich();

        changeSandwichSize();

        System.out.println("\nA " + sandwich.getName() + " Has The Following Toppings:");
        System.out.println(sandwich.toString());

        boolean userInput = ScannerIO.getBooleanInput("\nWould You Like To Edit The Sandwich? (yes or no): ");
        if (userInput) {
            ToppingScreen toppingScreen = new ToppingScreen(order, sandwich);
            toppingScreen.run();
        }

        boolean userToasted = ScannerIO.getBooleanInput("\nWould You Like To Toast Your Sandwich? (yes or no): ");
        sandwich.setToasted(userToasted);

        order.addSandwich(sandwich);
    }

    /*-----Private Methods-----*/
    private void validateSandwich() {
        while (true) {
            String userSandwich = ScannerIO.getStringInput("Type In The Name Of The Sandwich You Would Like: ");
            String[] sandwichInfo = itemManager.getItemInformation(userSandwich);
            if (sandwichInfo[0] != null && sandwichInfo[1] != null) {
                sandwich = new Sandwich(sandwichInfo[1]);
                return;
            } else {
                System.out.println("Oops, That Is Not A Correct Sandwich. Please Try Again");
            }
        }
    }

    private void changeSandwichSize() {
        boolean userChangeSize = ScannerIO.getBooleanInput("Currently Your Sandwich Is " +
                sandwich.getSize().getBreadSize() + " Would You Like To Change Size? (yes or no): ");

        if (userChangeSize) {
            while (true) {
                String userSize = ScannerIO.getStringInput("\nType In [Small] OR [Medium] OR [Large] To Change Size: ").toUpperCase();
                switch (userSize) {
                    case "SMALL", "MEDIUM", "LARGE" -> {
                        sandwich.setSize(Size.valueOf(userSize));
                        return;
                    }
                    default -> System.out.println("Oops, " + userSize + " Is Not A Valid Size. Please Try Again");
                }
            }
        }
    }
}
