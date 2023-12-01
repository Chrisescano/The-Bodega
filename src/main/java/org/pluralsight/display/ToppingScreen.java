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
        String userInput = ScannerIO.getStringInput(prompt);
        Topping userTopping = toppingManager.getTopping(userInput);

        //null check
        if (userTopping == null) {
            System.out.println("Oops, " + userInput + " Is Not A Valid Topping.");
            return;
        }

        //topping check
        boolean hasTopping = sandwichHasTopping(userTopping);

        //if true add extra
        if (isToAdd && hasTopping) {
            if (userTopping.getType().equalsIgnoreCase("breads")) {
                System.out.println("Cannot Have Extra Bread");
                return;
            }

            boolean userWantsExtra = ScannerIO.getBooleanInput("You Already Have This Topping. Add Extra? (yes or no): ");
            if (userWantsExtra) sandwich.addExtra(userTopping);
        }

        //add topping
        if (isToAdd && !hasTopping) {
            if (userTopping.getType().equalsIgnoreCase("breads")) {
                System.out.println("Cannot Have More Than One Bread");
                return;
            }
            sandwich.addTopping(userTopping);
        }

        //remove topping
        if (!isToAdd && hasTopping) {
            if (userTopping.getType().equalsIgnoreCase("breads")) {
                boolean changeBread = ScannerIO.getBooleanInput("We Don't Do Salads, Would You Like To Change Your Bread? ");
                if (changeBread) changeBread();
                return;
            }

            sandwich.removeTopping(userTopping);
        }

        //
        if (!isToAdd && !hasTopping) System.out.println("Cannot Remove What is Not There. Discarding...");
    }

    private boolean sandwichHasTopping(Topping topping) {
        for (Topping existingToppings : sandwich.getSandwichToppings()) {
            if (topping.getName().equalsIgnoreCase(existingToppings.getName())) {
                return true;
            }
        }
        return false;
    }

    private void changeBread() {
        while (true) {
            String userInput = ScannerIO.getStringInput("Type In Your Bread: ");
            Topping userTopping = toppingManager.getTopping(userInput);

            if (userTopping == null || !userTopping.getType().equalsIgnoreCase("breads")) {
                System.out.println("Not A Bread Topping. Try Again");
            } else {
                sandwich.getSandwichToppings().set(0, userTopping);
                return;
            }
        }
    }
}
