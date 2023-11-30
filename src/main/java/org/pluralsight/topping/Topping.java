package org.pluralsight.topping;

import org.pluralsight.shop.Size;
import java.util.HashMap;

public abstract class Topping {
    protected String toppingType;
    protected String toppingName;
    protected HashMap<Size, Double> toppingPrice;
    protected String[] toppingTokens;
    protected boolean extraOrdered;

    public Topping(String toppingInformation) {
        toppingTokens = toppingInformation.split("\\|");
        toppingPrice = new HashMap<>();
    }

    /*-----Setters-----*/

    public void setExtraOrdered(boolean extraOrdered) {
        this.extraOrdered = extraOrdered;
    }

    /*-----Getters-----*/
    public  String getType() {
        return toppingType;
    }
    public String getName() {
        return toppingName;
    }

    /*-----Abstract Methods-----*/
    public boolean isExtraOrdered() {
        return extraOrdered;
    }
    public abstract double getPrice(Size size);
}
