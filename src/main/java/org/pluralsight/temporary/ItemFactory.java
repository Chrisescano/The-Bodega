package org.pluralsight.temporary;

public class ItemFactory {

    public static Item buildSandwich(String itemInformation) {
        return new bSandwich(itemInformation);
    }

    public static Item buildChip(String itemInformation) {
        return new bChip(itemInformation);
    }

    public static Item buildDrink(String itemInformation) {
        return new bDrink(itemInformation);
    }
}
