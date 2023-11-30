package org.pluralsight.menuItems;

import org.pluralsight.shop.Size;

import java.util.HashMap;

public class Drink extends Item {
    private HashMap<Size, Double> itemPrices;

    public Drink(String itemInformation) {
        super(itemInformation);
        itemName = itemTokens[0];
        itemPrices = new HashMap<>();
        itemPrices.put(Size.SMALL, Double.valueOf(itemTokens[1]));
        itemPrices.put(Size.MEDIUM, Double.valueOf(itemTokens[2]));
        itemPrices.put(Size.LARGE, Double.valueOf(itemTokens[3]));
    }

    @Override
    public double getPrice(Size size) {
        return itemPrices.get(size);
    }

    @Override
    protected double getPrice() {
        return 0;
    }
}
