package org.pluralsight.topping;

import org.pluralsight.shop.Size;

import java.util.HashMap;

public class PremiumTopping extends Topping {
    private final HashMap<Size, Double> premiumPrice;

    public PremiumTopping(String toppingInformation, String toppingType) {
        super(toppingInformation);
        premiumPrice = new HashMap<>();

        toppingName = toppingTokens[0];
        toppingPrice.put(Size.SMALL, Double.valueOf(toppingTokens[1]));
        toppingPrice.put(Size.MEDIUM, Double.valueOf(toppingTokens[2]));
        toppingPrice.put(Size.LARGE, Double.valueOf(toppingTokens[3]));
        premiumPrice.put(Size.SMALL, Double.valueOf(toppingTokens[4]));
        premiumPrice.put(Size.MEDIUM, Double.valueOf(toppingTokens[5]));
        premiumPrice.put(Size.LARGE, Double.valueOf(toppingTokens[6]));
        extraOrdered = false;
        this.toppingType = toppingType;
    }

    @Override
    public double getPrice(Size size) {
        return extraOrdered ? toppingPrice.get(size) + premiumPrice.get(size) :
                toppingPrice.get(size);
    }

    @Override
    public String getName() {
        return extraOrdered ? toppingName + " (Extra)" : toppingName;
    }
}
