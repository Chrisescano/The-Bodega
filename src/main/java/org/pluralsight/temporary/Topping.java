package org.pluralsight.temporary;

import org.pluralsight.shop.Size;
import java.util.HashMap;

public abstract class Topping {
    protected String toppingName;
    protected HashMap<Size, Double> toppingPrices;
    protected String[] toppingTokens;
    protected boolean extraOrdered;

    public Topping(String toppingInformation) {
        toppingTokens = toppingInformation.split("\\|");
        toppingPrices = new HashMap<>();
    }

    /*-----Setters-----*/

    public void setExtraOrdered(boolean extraOrdered) {
        this.extraOrdered = extraOrdered;
    }

    /*-----Getters-----*/

    public String getToppingName() {
        return toppingName;
    }

    public boolean isExtraOrdered() {
        return extraOrdered;
    }

    public abstract double getPrice(Size size);
}
