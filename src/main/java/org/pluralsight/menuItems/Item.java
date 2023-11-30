package org.pluralsight.menuItems;

import org.pluralsight.shop.Size;

public abstract class Item {
    protected String itemName;
    protected String[] itemTokens;
    protected double price;
    protected Size size;

    public Item(String itemInformation) {
        itemTokens = itemInformation.split("\\|");
    }

    /*-----Getters-----*/
    public String getName() {
        return itemName;
    }

    public abstract double getPrice(Size size);
    public abstract double getPrice();
    public abstract String getItemType();
    public abstract Size getSize();
}
