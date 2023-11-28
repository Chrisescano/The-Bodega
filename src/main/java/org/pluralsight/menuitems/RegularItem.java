package org.pluralsight.menuitems;

import org.pluralsight.shop.Size;

public class RegularItem extends Item{
    public RegularItem(String itemInformation) {
        String[] itemParts = itemInformation.split("\\|");
        itemName = itemParts[0];

        itemPrices.put(Size.SMALL, Double.valueOf(itemParts[1]));
        itemPrices.put(Size.MEDIUM, Double.valueOf(itemParts[2]));
        itemPrices.put(Size.LARGE, Double.valueOf(itemParts[3]));
    }

    /*-----Getters-----*/
    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public double getPrice(Size breadSize) {
        return isOrdered ? itemPrices.get(breadSize) : 0;
    }
}
