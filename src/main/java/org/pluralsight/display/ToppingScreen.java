package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuItems.Sandwich;
import org.pluralsight.shop.Order;
import org.pluralsight.topping.Topping;
import org.pluralsight.topping.ToppingManager;
import org.pluralsight.util.ToppingTable;

import java.util.ArrayList;

public class ToppingScreen implements Displayable {
    ToppingTable toppingTable;
    ToppingManager toppingManager;
    Order order;
    Sandwich sandwich;

    public ToppingScreen(Order order, Sandwich sandwich) {
        this.order = order;
        this.sandwich = sandwich;
        toppingTable = new ToppingTable();
        toppingManager = new ToppingManager();
    }

    @Override
    public void screen() {
        System.out.println("""
                
                Here Is A Menu Of All The Toppings
                """);
        toppingTable.run();
    }

    @Override
    public void run() {
        screen();
        printUserOptions();
    }

    private void printUserOptions() {
        while (true) {
            System.out.println("""
                            To Edit Your Sandwich:
                              (1) - Add A Topping
                              (2) - Remove A Topping
                              (3) - Exit
                            """
            );
            int userCommand = ScannerIO.getIntInput("Type In Your Command: ");
            switch (userCommand) {
                case 1 -> validateEdit(true);
                case 2 -> validateEdit(false);
                case 3 -> { return; }
                default -> System.out.println("Oops, I Did Not Recognize " + userCommand + " As A Valid Command.\n");
            }
        }
    }

    private void validateEdit(boolean isToAdd) {
        String prompt = isToAdd ? "Type In Topping To Add: " : "Type In Topping To Remove: ";
        String userTopping = ScannerIO.getStringInput(prompt);
        Topping toppingToEdit = toppingManager.getTopping(userTopping);


    }
}
