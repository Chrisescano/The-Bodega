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

    public int addBread(String itemName) {
        for(Item bread : breadTypeIM.getItemList()) {
            if (bread.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(bread);
                price += bread.getPrice(breadSize);
                return 0;
            }
        }
        return -1;
    }

    public int addMeat(String itemName) {
        for (Item meat : meatIM.getItemList()) {
            if (meat.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(meat);
                price += meat.getPrice(breadSize);
                return 0;
            }
        }
        return -1;
    }

    public int addCheese(String itemName) {
        for (Item cheese : cheeseIM.getItemList()) {
            if (cheese.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(cheese);
                price += cheese.getPrice(breadSize);
                return 0;
            }
        }
        return -1;
    }

    public int addRegularTopping(String itemName) {
        for (Item regular : regularIM.getItemList()) {
            if (regular.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(regular);
                price += regular.getPrice(breadSize);
                return 0;
            }
        }
        return -1;
    }

    public int addSauce(String itemName) {
        for (Item sauce : sauceIM.getItemList()) {
            if (sauce.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(sauce);
                price += sauce.getPrice(breadSize);
                return 0;
            }
        }
        return -1;
    }

    public int addSide(String itemName) {
        for (Item side : sideIM.getItemList()) {
            if (side.getItemName().equalsIgnoreCase(itemName)) {
                sandwichItems.add(side);
                price += side.getPrice(breadSize);
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
