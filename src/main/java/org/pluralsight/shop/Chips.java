package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

public class Chips {
    ItemManager chipItems;

    public Chips() {
        chipItems = new ItemManager("chips.csv", false);
    }

    public void order(String itemName) {
        for (Item chip : chipItems.getItemList()) {
            if (chip.getItemName().equals(itemName)) chip.orderItem();
        }
    }

    /*-----Getters-----*/

}
