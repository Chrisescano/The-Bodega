package org.pluralsight.temporary;

import org.pluralsight.shop.Size;

public class RegularTopping extends Topping {
    public RegularTopping(String toppingInformation) {
        super(toppingInformation);
        toppingName = toppingTokens[0];
        toppingPrices.put(Size.SMALL, Double.valueOf(toppingTokens[1]));
        toppingPrices.put(Size.MEDIUM, Double.valueOf(toppingTokens[2]));
        toppingPrices.put(Size.LARGE, Double.valueOf(toppingTokens[3]));
    }

    @Override
    public double getPrice(Size size) {
        return toppingPrices.get(size);
    }
}
