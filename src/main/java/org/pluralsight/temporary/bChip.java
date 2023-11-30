package org.pluralsight.temporary;

import org.pluralsight.shop.Size;
import java.util.HashMap;

public class bChip extends Item {
    private final HashMap<Size, Double> itemPrice;

    public bChip(String itemInformation) {
        super(itemInformation);
        itemName = itemTokens[0];
        itemPrice = new HashMap<>();
        itemPrice.put(Size.SMALL, Double.valueOf(itemTokens[1]));
        itemPrice.put(Size.MEDIUM, Double.valueOf(itemTokens[2]));
        itemPrice.put(Size.LARGE, Double.valueOf(itemTokens[3]));
    }

    @Override
    public double getPrice(Size size) {
        return itemPrice.get(size);
    }

    @Override
    protected double getPrice() {
        return 0;
    }

}
