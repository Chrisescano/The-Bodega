package org.pluralsight.topping;

import org.pluralsight.shop.Size;

public class RegularTopping extends Topping {
    public RegularTopping(String toppingInformation, String toppingType) {
        super(toppingInformation);
        toppingName = toppingTokens[0];
        toppingPrice.put(Size.SMALL, Double.valueOf(toppingTokens[1]));
        toppingPrice.put(Size.MEDIUM, Double.valueOf(toppingTokens[2]));
        toppingPrice.put(Size.LARGE, Double.valueOf(toppingTokens[3]));
        this.toppingType = toppingType;
    }

    @Override
    public double getPrice(Size size) {
        return toppingPrice.get(size);
    }
}
