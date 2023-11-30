package org.pluralsight.temporary;

import org.pluralsight.shop.Size;

import java.util.HashMap;

public class PremiumTopping extends Topping{
    private HashMap<Size, Double> premiumPrice;

    public PremiumTopping(String toppingInformation) {
        super(toppingInformation);
        premiumPrice = new HashMap<>();

        toppingName = toppingTokens[0];
        toppingPrices.put(Size.SMALL, Double.valueOf(toppingTokens[1]));
        toppingPrices.put(Size.MEDIUM, Double.valueOf(toppingTokens[2]));
        toppingPrices.put(Size.LARGE, Double.valueOf(toppingTokens[3]));
        premiumPrice.put(Size.SMALL, Double.valueOf(toppingTokens[4]));
        premiumPrice.put(Size.MEDIUM, Double.valueOf(toppingTokens[5]));
        premiumPrice.put(Size.LARGE, Double.valueOf(toppingTokens[6]));
    }

    @Override
    public double getPrice(Size size) {
        return 0;
    }
}
