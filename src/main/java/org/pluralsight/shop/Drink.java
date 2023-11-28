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
    public Drink() {
        this.itemManager = new ItemManager("drinks.csv", false);
     //ItemManager = new ItemManager("drinks.csv", false);
    }



    public void selectedDrink() {

        ArrayList<Item> drinkOptions = itemManager.getItemList();

        for (int i = 0; i < drinkOptions.size(); i++) {
            System.out.println((i + 1) + ". " + drinkOptions.get(i).getItemName());
        }

    }
   //Adding addToOrder method
}