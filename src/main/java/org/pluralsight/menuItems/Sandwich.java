package org.pluralsight.menuItems;

import org.pluralsight.shop.Size;
import org.pluralsight.topping.RegularTopping;
import org.pluralsight.topping.Topping;
import org.pluralsight.topping.ToppingManager;

import java.util.ArrayList;

public class Sandwich extends Item {
    ToppingManager toppingManager;
    private final ArrayList<Topping> sandwichToppings;
    private boolean isToasted;

    public Sandwich(String itemInformation) {
        super(itemInformation);
        toppingManager = new ToppingManager();
        sandwichToppings = new ArrayList<>();

        itemName = itemTokens[0];
        price = Double.parseDouble(itemTokens[1]);
        size = Size.valueOf(itemTokens[2].toUpperCase());
        isToasted = itemTokens[3].equalsIgnoreCase("toasted");

        for (int i = 4; i < itemTokens.length; i++) {
            sandwichToppings.add(toppingManager.getTopping(itemTokens[i]));
        }
    }

    public void addTopping(Topping topping) {
        sandwichToppings.add(topping);
        price += topping.getPrice(size);
    }

    public void removeTopping(Topping topping) {
       for (Topping included : sandwichToppings) {
           if (included.getName().equalsIgnoreCase(topping.getName())) {
               sandwichToppings.remove(included);
               price -= topping.getPrice(size);
           }
       }
    }

    public void addExtra(Topping topping) {
        for (Topping included : sandwichToppings) {
            if (included.getName().equalsIgnoreCase(topping.getName())) {
                included.setExtraOrdered(true);
            }
        }
    }

    /*-----Getters-----*/
    public boolean isToasted() {
        return isToasted;
    }

    public ArrayList<Topping> getSandwichToppings() {
        return sandwichToppings;
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
    public double getPrice() {
        return price;
    }

    @Override
    public String getItemType() {
        return "sandwich";
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public String print() {
        return null;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder toppingBuilder = new StringBuilder();
        for (Topping topping : sandwichToppings) {
            toppingBuilder.append("[ ").append(topping.getName()).append(" ]");
        }
        return toppingBuilder.toString();
    }
}
