package org.pluralsight.temporary;

import org.pluralsight.shop.Size;

public abstract class Item {
    protected String itemName;
    protected String[] itemTokens;
    protected double price;

    public Item(String itemInformation) {
        itemTokens = itemInformation.split("\\|");
    }

    public String getItemName() {
        return itemName;
    }

    public abstract double getPrice(Size size);
    protected abstract double getPrice();
}
