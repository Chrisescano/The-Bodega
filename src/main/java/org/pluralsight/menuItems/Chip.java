package org.pluralsight.menuItems;

import org.pluralsight.shop.Size;
import org.pluralsight.util.TerminalFormat;

import java.util.HashMap;

public class Chip extends Item {
    private final HashMap<Size, Double> itemPrice;

    public Chip(String itemInformation) {
        super(itemInformation);
        itemName = itemTokens[0];
        itemPrice = new HashMap<>();
        itemPrice.put(Size.SMALL, Double.valueOf(itemTokens[1]));
        itemPrice.put(Size.MEDIUM, Double.valueOf(itemTokens[2]));
        itemPrice.put(Size.LARGE, Double.valueOf(itemTokens[3]));
        size = Size.MEDIUM;
    }

    @Override
    public double getPrice(Size size) {
        return itemPrice.get(size);
    }

    @Override
    public double getPrice() {
        return getPrice(size);
    }

    @Override
    public String getItemType() {
        return "chip";
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public String print() {
        TerminalFormat terminalFormat = new TerminalFormat();

        return terminalFormat.tableRow(
                itemName, String.valueOf(getPrice(size)), "between"
        ) + "\n";
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

}
