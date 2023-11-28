package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

import java.util.ArrayList;

public class Chip {
    ArrayList<Item> chips;

    public static void main(String[] args) {
        Chip chips = new Chip();
    }

    public Chip() {
        chips = new ItemManager("chips.csv", false).getItemList();
    }
}