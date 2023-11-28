package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

import java.util.ArrayList;

public class Chips {
    ArrayList<Item> chips;

    public static void main(String[] args) {
        Chips chips = new Chips();
    }

    public Chips() {
        chips = new ItemManager("chips.csv", false).getItemList();
    }
}