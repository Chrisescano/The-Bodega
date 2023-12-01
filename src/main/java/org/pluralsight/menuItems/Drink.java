package org.pluralsight.menuItems;

import org.pluralsight.shop.Size;

import java.util.HashMap;

public class Drink extends Item {
    private final HashMap<Size, Double> itemPrices;
    Size size;

    public Drink(String itemInformation) {
        super(itemInformation);
        itemName = itemTokens[0];
        itemPrices = new HashMap<>();
        itemPrices.put(Size.SMALL, Double.valueOf(itemTokens[1]));
        itemPrices.put(Size.MEDIUM, Double.valueOf(itemTokens[2]));
        itemPrices.put(Size.LARGE, Double.valueOf(itemTokens[3]));
        size = Size.MEDIUM;
    }

    /*-----Setters-----*/

    @Override
    public double getPrice(Size size) {
        return itemPrices.get(size);
    }

    @Override
    public double getPrice() {
        return getPrice(size);
    }

    @Override
    public String getItemType() {
        return "drink";
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public String print() {
        return null;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }
}
