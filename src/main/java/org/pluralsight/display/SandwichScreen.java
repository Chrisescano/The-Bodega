package org.pluralsight.display;

import org.pluralsight.shop.Order;
import org.pluralsight.shop.Size;

import java.util.ArrayList;

public class SandwichScreen implements Displayable{
    //Order order;
    //Sandwich sandwich;

    SandwichScreen(Order order) {
        //this.order = order;
        //sandwich = new Sandwich();
    }

    @Override
    public void screen() {
        System.out.print("""
                
                Let's Guide You Through The Sandwich Making Process
                """);
    }

    @Override
    public void run() {
//        display();
//        chooseSizeGuide();
//        chooseItemGuide("Here Are The Different Breads We Have", "Bread", sandwich.getBreads());
//        chooseItemGuide("Here Are The Different Meats We Have", "Meat", sandwich.getMeats());
//        chooseItemGuide("Here Are The Different Cheeses We Have", "Cheese", sandwich.getCheeses());
//        chooseItemGuide("Here Are The Different Regular Toppings We Have", "Regular Toppings", sandwich.getRegularToppings());
//        chooseItemGuide("Here Are The Different Sauces We Have", "Sauces", sandwich.getSauces());
//        chooseItemGuide("Here Are The Different Sides We Have", "Sides", sandwich.getSides());
//        sandwichToastPrompt();
//
//        order.addSandwich(sandwich);

        //Todo:
        //validate that the order looks correct to the user
    }

    /*-----Private Methods-----*/
//    private void chooseItemGuide(String message, String type, ArrayList<Item> list) {
//        int flag = -1;
//        while (flag == -1) {
//            System.out.println("\n" + message);
//            for (Item item : list) item.toTerminal();
//            String userChoice = ScannerIO.getStringInput("Type In The " + type + " You Would Like: ");
//            flag = sandwich.addItem(userChoice, list);
//
//            if (flag == -1)
//                System.out.println("Oops, We Do Not Have " + userChoice + " As A " + type + ". Please Try Again");
//        }
//    }

    private void chooseSizeGuide() {
//        int flag = -1;
//        while (flag == -1) {
//            printSandwichSizes();
//            String userSize = ScannerIO.getStringInput("Type In The Bread Size You Would Like: ");
//
//            for (Size size : Size.values()) {
//                if (userSize.equalsIgnoreCase(size.name())) {
//                    sandwich.setBreadSize(size);
//                    flag = 0;
//                }
//            }
//
//            if (flag == -1) {
//                System.out.println("Oops, We Do Not Have " + userSize + " As A Bread Size. Please Try Again");
//            }
//        }
    }

    private void sandwichToastPrompt() {
//        boolean userInput = ScannerIO.getBooleanInput("Would You Like Your Sandwich Toasted? (yes or no)");
//        sandwich.setIsToasted(userInput);
    }

    /*-----Helper Methods-----*/

//    private void printSandwichItems(String prompt, ArrayList<Item> items) {
//        System.out.println("\n" + prompt);
//        for (Item item : items) item.toTerminal();
//    }

    private void printSandwichSizes() {
        System.out.println("\nHere Are The Different Bread Sizes We Have: ");
        for (Size size : Size.values()) System.out.println(size);
    }
}
