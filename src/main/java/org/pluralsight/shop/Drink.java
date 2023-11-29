package org.pluralsight.shop;


import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

import java.util.ArrayList;


public class Drink {

    private final ArrayList<Item> drinks;

    public static void main(String[] args) {
        Drink drink = new Drink();
        drink.selectedDrink();
    }


    public final ArrayList<Item> getDrinks() {
        return drinks;
    }

    public Drink() {
        drinks = new ItemManager("drinks.csv", false).getItemList();
    }


    public void selectedDrink() {
        System.out.println("Drinks List:");
        for (Item drink : drinks) {
            System.out.println(drink.getItemName());
            System.out.println("   Small: $" + drink.getPrice(Size.SMALL));
            System.out.println("   Medium: $" + drink.getPrice(Size.MEDIUM));
            System.out.println("   Large: $" + drink.getPrice(Size.LARGE));
        }

    }


    public int addDrink(String flavor) {
        for (Item drink : drinks) {
            if (drink.getItemName().equalsIgnoreCase(flavor)) {
                drinks.add(drink);
                System.out.println("added" + flavor);
        

                return 0;
            }
        }
        return 1;
    }



    //Adding addToOrder method

  
}



