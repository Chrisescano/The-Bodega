package org.pluralsight.menuItems;

public class ItemFactory {

    public static Item buildSandwich(String itemInformation) {
        return new Sandwich(itemInformation);
    }

    public static Item buildChip(String itemInformation) {
        return new Chip(itemInformation);
    }

    public static Item buildDrink(String itemInformation) {
        return new Drink(itemInformation);
    }
}
