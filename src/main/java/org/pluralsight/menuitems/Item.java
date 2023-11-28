package org.pluralsight.menuitems;

import org.pluralsight.shop.Size;

import java.util.HashMap;

public abstract class Item {
    protected String itemName;
    protected HashMap<Size, Double> itemPrices = new HashMap<>();

    public abstract String getItemName();
    public abstract double getPrice(Size breadSize);

    public abstract void toTerminal();
}
