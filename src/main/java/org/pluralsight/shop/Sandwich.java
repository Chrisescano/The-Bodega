package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

import java.util.ArrayList;

public class Sandwich {
    private final ItemManager breadTypeIM, cheeseIM, meatIM, regularIM, sauceIM, sideIM;
    private ArrayList<Item> sandwichItems;
    private Size breadSize;

    public Sandwich() {
        breadTypeIM = new ItemManager("breads.csv", false);
        cheeseIM = new ItemManager("cheeses.csv", true);
        meatIM = new ItemManager("meats.csv", true);
        regularIM = new ItemManager("regular.csv", false);
        sauceIM = new ItemManager("sauces.csv", false);
        sideIM = new ItemManager("sides.csv", false);
        sandwichItems = new ArrayList<>();
    }

    public int addMeat(String itemName) {
        for (Item meat : meatIM.getItemList()) {
            if (meat.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(meat);
                return 0;
            }
        }
        return -1;
    }

    public int addCheese(String itemName) {
        for (Item cheese : cheeseIM.getItemList()) {
            if (cheese.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(cheese);
                return 0;
            }
        }
        return -1;
    }

    public int addRegularTopping(String itemName) {
        for (Item regular : regularIM.getItemList()) {
            if (regular.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(regular);
                return 0;
            }
        }
        return -1;
    }

    public int addSauce(String itemName) {
        for (Item sauce : sauceIM.getItemList()) {
            if (sauce.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(sauce);
                return 0;
            }
        }
        return -1;
    }

    public int addSide(String itemName) {
        for (Item side : sideIM.getItemList()) {
            if (side.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(side);
                return 0;
            }
        }
        return -1;
    }

    public void remove(Item item) {
        sandwichItems.remove(item);
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
