package org.pluralsight.menuitems;

import org.pluralsight.shop.Size;

import java.util.HashMap;

public class PremiumItem extends Item {
    private boolean extraOrdered = false;
    private final HashMap<Size, Double> extraPrices = new HashMap<>();

    public PremiumItem(String itemInformation) {
        String[] itemParts = itemInformation.split("\\|");
        itemName = itemParts[0];

        itemPrices.put(Size.SMALL, Double.valueOf(itemParts[1]));
        itemPrices.put(Size.MEDIUM, Double.valueOf(itemParts[2]));
        itemPrices.put(Size.LARGE, Double.valueOf(itemParts[3]));

        extraPrices.put(Size.SMALL, Double.valueOf(itemParts[4]));
        extraPrices.put(Size.MEDIUM, Double.valueOf(itemParts[5]));
        extraPrices.put(Size.LARGE, Double.valueOf(itemParts[6]));
    }

    @Override
    public void toTerminal() {
        System.out.printf("%s $%.2f $%.2f $%.2f\n", itemName,
                getPrice(Size.SMALL), getPrice(Size.MEDIUM), getPrice(Size.LARGE));
    }

    /*-----Getters-----*/
    public boolean isExtraOrdered() {
        return extraOrdered;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public double getPrice(Size breadSize) {
        return !isOrdered ? 0 : extraOrdered ? itemPrices.get(breadSize) + extraPrices.get(breadSize) :
                itemPrices.get(breadSize);
    }

    /*-----Setters-----*/
    public void setExtraOrdered(boolean extraOrdered) {
        this.extraOrdered = extraOrdered;
    }
}
