package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

import java.util.ArrayList;

public class Sandwich {
    private final ItemManager breadTypeIM;
    private final ItemManager cheeseIM;
    private final ItemManager meatIM;
    private final ItemManager regularIM;
    private final ItemManager sauceIM;
    private final ItemManager sideIM;

    public Sandwich() {
        breadTypeIM = new ItemManager("breads.csv", false);
        cheeseIM = new ItemManager("cheeses.csv", true);
        meatIM = new ItemManager("meats.csv", true);
        regularIM = new ItemManager("regular.csv", false);
        sauceIM = new ItemManager("sauces.csv", false);
        sideIM = new ItemManager("sides.csv", false);
    }


    /*-----Getters-----*/
    public ArrayList<Item> getBreadToppings() {
        return breadTypeIM.getItemList();
    }

    public ArrayList<Item> getMeatToppings() {
        return meatIM.getItemList();
    }

    public ArrayList<Item> getCheeseToppings() {
        return cheeseIM.getItemList();
    }

    public ArrayList<Item> getRegularToppings() {
        return regularIM.getItemList();
    }

    public ArrayList<Item> getSauceToppings() {
        return sauceIM.getItemList();
    }

    public ArrayList<Item> getSideToppings() {
        return sideIM.getItemList();
    }
}

/* Sandwich class
* Get breadtype
* Prompt user for breadsize
    * Get breadsize
* Prompt user for Regular toppings or Premium Toppings
    * Get toppings
* */
