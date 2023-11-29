package org.pluralsight.shop;


import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;
import java.util.ArrayList;


public class Drink {
    public static void main(String[] args) {

        Drink drink = new Drink();
        drink.selectedDrink();
    }

    private ItemManager itemManager;
    private Item selectedDrink;

    public Drink() {
        this.itemManager = new ItemManager("drinks.csv", false);
    }


    public void selectedDrink() {

      //  ArrayList<Item> drinkOptions = itemManager.getItemList();
        for (int i = 0; i < itemManager.getItemList().size(); i++) {
            System.out.println(itemManager.getItemList().get(i).getItemName());
            System.out.println("   Small: $" + itemManager.getItemList().get(i).getPrice(Size.SMALL));
            System.out.println("   Meduim: $" + itemManager.getItemList().get(i).getPrice(Size.MEDIUM));
            System.out.println("   Large: $" + itemManager.getItemList().get(i).getPrice(Size.LARGE));

        }
    }

    //Adding addToOrder method
  
}



