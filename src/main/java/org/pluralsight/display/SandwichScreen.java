package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuItems.ItemManager;
import org.pluralsight.menuItems.Sandwich;
import org.pluralsight.shop.Order;
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

        System.out.println("\nA " + sandwich.getName() + " Has The Following Toppings:");
        System.out.println(sandwich.toString());

        boolean userInput = ScannerIO.getBooleanInput("\nWould You Like To Edit The Sandwich? (yes or no): ");
        if (userInput) {
            ToppingScreen toppingScreen = new ToppingScreen(order, sandwich);
            toppingScreen.run();
        }
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
}
