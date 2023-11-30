package org.pluralsight.shop;

import org.pluralsight.menuItems.Chip;
import org.pluralsight.menuItems.Drink;
import org.pluralsight.menuItems.Item;
import org.pluralsight.menuItems.Sandwich;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Item> items;
    private double price;

    public Order() {
        items = new ArrayList<>();
        price = 0;
    }

    public void addSandwich(Sandwich sandwich) {
        items.add(sandwich);
        price += sandwich.getPrice();
    }

    public void addChip(Chip chip) {
        items.add(chip);
        price += chip.getPrice();
    }

    public void addDrink(Drink drink) {
        items.add(drink);
        price += drink.getPrice();
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    /*-----Getter-----*/
    public double getPrice() {
        return price;
    }
}
