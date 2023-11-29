package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuitems.Item;
import org.pluralsight.shop.Sandwich;
import org.pluralsight.shop.Size;

import java.util.ArrayList;

public class SandwichScreen implements Displayable{
    Sandwich sandwich;

    SandwichScreen() {
        sandwich = new Sandwich();
    }

    @Override
    public void display() {
        System.out.print("""
                
                Let's Guide You Through The Sandwich Making Process
                """);
    }

    @Override
    public void run() {
        display();
        chooseBreadGuide();
        chooseSizeGuide();
        chooseMeatGuide();
        chooseCheeseGuide();
        chooseRegularGuide();
        chooseSauceGuide();
        chooseSideGuide();

        //ask user for extra of toppings
        //save to order
        //print receipt
        //save receipt
    }

    /*-----Private Methods-----*/
    private void chooseBreadGuide() {
        int flag = -1;
        while (flag == -1) {
            printSandwichItems("Here Are The Different Breads We Have", sandwich.getBreadToppings());
            String userBread = ScannerIO.getStringInput("Type In The Bread You Would Like: ");
            flag = sandwich.addBread(userBread);

            if (flag == -1) {
                System.out.println("Oops, We Do Not Have " + userBread + " As A Bread. Please Try Again");
            }
        }
    }

    private void chooseSizeGuide() {
        int flag = -1;
        while (flag == -1) {
            printSandwichSizes();
            String userSize = ScannerIO.getStringInput("Type In The Bread Size You Would Like: ");

            for (Size size : Size.values()) {
                if (userSize.equalsIgnoreCase(size.name())) {
                    sandwich.setBreadSize(size);
                    flag = 0;
                }
            }

            if (flag == -1) {
                System.out.println("Oops, We Do Not Have " + userSize + " As A Bread Size. Please Try Again");
            }
        }
    }

    private void chooseMeatGuide() {
        int flag = -1;
        while (flag == -1) {
            printSandwichItems("Here Are The Different Meat Toppings We Have", sandwich.getMeatToppings());
            String userMeat = ScannerIO.getStringInput("Type In The Meat Topping You Would Like: ");
            flag = sandwich.addMeat(userMeat);

            if (flag == -1) {
                System.out.println("Oops, We Do Not Have " + userMeat + " As A Bread Size. Please Try Again");
            }
        }
    }

    private void chooseCheeseGuide() {
        int flag = -1;
        while (flag == -1) {
            printSandwichItems("Here Are The Different Cheese Toppings We Have", sandwich.getCheeseToppings());
            String userCheese = ScannerIO.getStringInput("Type In The Cheese Topping You Would Like: ");
            flag = sandwich.addCheese(userCheese);

            if (flag == -1) {
                System.out.println("Oops, We Do Not Have " + userCheese + " As A Cheese. Please Try Again");
            }
        }
    }

    private void chooseRegularGuide() {
        int flag = -1;
        while (flag == -1) {
            printSandwichItems("Here Are The Different Regular Toppings We Have", sandwich.getRegularToppings());
            String userRegular = ScannerIO.getStringInput("Type In The Regular Topping You Would Like: ");
            flag = sandwich.addRegularTopping(userRegular);

            if (flag == -1) {
                System.out.println("Oops, We Do Not Have " + userRegular + " As A Regular Topping. Please Try Again");
            }
        }
    }

    private void chooseSauceGuide() {
        int flag = -1;
        while (flag == -1) {
            printSandwichItems("Here Are The Different Sauces We Have", sandwich.getSauceToppings());
            String userSauce = ScannerIO.getStringInput("Type In The Sauce You Would Like: ");
            flag = sandwich.addSauce(userSauce);

            if (flag == -1) {
                System.out.println("Oops, We Do Not Have " + userSauce+ " As A Sauce. Please Try Again");
            }
        }
    }

    private void chooseSideGuide() {
        int flag = -1;
        while (flag == -1) {
            printSandwichItems("Here Are The Different Sides We Have", sandwich.getSideToppings());
            String userSide = ScannerIO.getStringInput("Type In The Side You Would Like: ");
            flag = sandwich.addSide(userSide);

            if (flag == -1) {
                System.out.println("Oops, We Do Not Have " + userSide + " As A Side. Please Try Again");
            }
        }
    }

    private void sandwichToastPrompt() {
        boolean userInput = ScannerIO.getBooleanInput("Would You Like Your Sandwich Toasted? (yes or no)");
        sandwich.setIsToasted(userInput);
    }

    /*-----Helper Methods-----*/

    private void printSandwichItems(String prompt, ArrayList<Item> items) {
        System.out.println(prompt);
        for (Item item : items) item.toTerminal();
    }

    private void printSandwichSizes() {
        System.out.println("Here Are The Different Bread Sizes We Have: ");
        for (Size size : Size.values()) System.out.println(size);
    }

    /*-----Getters-----*/
    public Sandwich getSandwich() {
        return sandwich;
    }

}
