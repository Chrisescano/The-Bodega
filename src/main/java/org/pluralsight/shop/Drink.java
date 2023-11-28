package org.pluralsight.shop;


import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;
import java.util.ArrayList;

public class Drink {
    public static void main(String[] args) {
        Drink drink = new Drink();
        drink.selectedDrink();
    }

    private ItemManager itemManager;
    private Item selectedDrink;
//    private Size size;
//    private String flavor;
    public Drink() {
        itemManager = new ItemManager("drinks.csv", false);
    }

    public void selectedDrink() {
        System.out.println("Select a drink:");

        ArrayList<Item> drinkOptions = itemManager.getItemList();

        for (int i = 0; i < drinkOptions.size(); i++) {
            System.out.println((i + 1) + ". " + drinkOptions.get(i).getItemName());
        }

        int option = ScannerIO.getIntInput("Enter the drink option: ");

        if (option >= 1 && option <= drinkOptions.size()) {
            selectedDrink = drinkOptions.get(option - 1);
            System.out.println("Drink Selected: " + selectedDrink.getItemName());
        } else {
            System.out.println("Error! Tru again.");
        }

    }


}
