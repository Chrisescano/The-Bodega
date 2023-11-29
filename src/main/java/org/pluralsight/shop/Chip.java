package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

import java.util.ArrayList;

public class Chip {
    private final ArrayList<Item> chips;

    public static void main(String[] args) {
        Chip chips = new Chip();
        chips.selectChip();
    }

    public Chip() {
        chips = new ItemManager("chips.csv", false).getItemList();
    }

    public final ArrayList<Item> getChips() {
        return chips;
    }

    public void selectChip() {
        System.out.println("Chips List:");
        for (Item chip : chips) {
            System.out.println(chip.getItemName());
        }
    }

    public int addChips(String itemName) {
        for (Item chip : chips) {
            if (chip.getItemName().equalsIgnoreCase(itemName)) {
                chips.add(chip);
                return 0;
            }
        }
        return 1;
    }

    public void remove(Item item) {
        chips.remove(item);
    }
}