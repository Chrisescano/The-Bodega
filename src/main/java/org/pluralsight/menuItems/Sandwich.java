package org.pluralsight.menuItems;

import org.pluralsight.shop.Size;
import org.pluralsight.topping.Topping;
import org.pluralsight.topping.ToppingManager;

import java.util.ArrayList;

public class Sandwich extends Item {
    ToppingManager toppingManager;
    private ArrayList<Topping> sandwichToppings;
    private Size size;
    private boolean isToasted;

    public Sandwich(String itemInformation) {
        super(itemInformation);
        toppingManager = new ToppingManager();

        itemName = itemTokens[0];
        price = Double.parseDouble(itemTokens[1]);
        size = Size.valueOf(itemTokens[2].toUpperCase());
        isToasted = itemTokens[3].equalsIgnoreCase("toasted");

        for (int i = 4; i < itemTokens.length; i++) {
            sandwichToppings.add(toppingManager.getTopping(itemTokens[i]));
        }
    }

    public void addTopping(String toppingName) {
        Topping topping;
        if ((topping = toppingManager.getTopping(toppingName)) != null)
            sandwichToppings.add(topping);
    }

    public void removeTopping(String toppingName) {
        sandwichToppings.removeIf(topping -> topping.getName().equalsIgnoreCase(toppingName));
    }

    /*-----Getters-----*/
    public boolean isToasted() {
        return isToasted;
    }

    /*-----Setters-----*/
    public void setToasted(boolean isToasted) {
        this.isToasted = isToasted;
    }

    @Override
    public double getPrice(Size size) {
        return 0;
    }

    @Override
    protected double getPrice() {
        return price;
    }
}
