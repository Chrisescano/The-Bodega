package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

import java.util.ArrayList;

public class Sandwich {
    private final ItemManager breadTypeIM, cheeseIM, meatIM, regularIM, sauceIM, sideIM;
    private final ArrayList<Item> sandwichItems;
    private Size breadSize;
    private boolean isToasted = false;
    private double price = 0;

    public Sandwich() {
        breadTypeIM = new ItemManager("breads.csv", false);
        cheeseIM = new ItemManager("cheeses.csv", true);
        meatIM = new ItemManager("meats.csv", true);
        regularIM = new ItemManager("regular.csv", false);
        sauceIM = new ItemManager("sauces.csv", false);
        sideIM = new ItemManager("sides.csv", false);
        sandwichItems = new ArrayList<>();
    }

    public int addItem(String itemName, ArrayList<Item> itemList) {
        for (Item item : itemList) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(item);
                price += item.getPrice(breadSize);
                return 0;
            }
        }
        return -1;
    }

    public void remove(Item item) {
        sandwichItems.remove(item);
    }

    /*-----Getters-----*/
    public ArrayList<Item> getBreads() {
        return breadTypeIM.getItemList();
    }

    public ArrayList<Item> getMeats() {
        return meatIM.getItemList();
    }

    public ArrayList<Item> getCheeses() {
        return cheeseIM.getItemList();
    }

    public ArrayList<Item> getRegularToppings() {
        return regularIM.getItemList();
    }

    public ArrayList<Item> getSauces() {
        return sauceIM.getItemList();
    }

    public ArrayList<Item> getSides() {
        return sideIM.getItemList();
    }

    public ArrayList<Item> getSandwichItems() {
        return sandwichItems;
    }

    public Size getBreadSize() {
        return breadSize;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public double getPrice() {
        return price;
    }

    /*-----Setters-----*/
    public void setBreadSize(Size breadSize) {
        this.breadSize = breadSize;
    }

    public void setIsToasted(boolean isToasted) {
        this.isToasted = isToasted;
    }
}
