package org.pluralsight.menuitems;

import org.pluralsight.io.FileManager;

import java.util.ArrayList;

public class ItemManager {
    FileManager fileManager;
    ArrayList<Item> itemList = new ArrayList<>();
    boolean isPremium;

    public ItemManager(String fileName, boolean isPremium) {
        this.isPremium = isPremium;

        fileManager = new FileManager("MenuItems/");
        String fileContents = fileManager.readFromFile(fileName);
        String[] menuItems = fileContents.split("\n");

        for (String item : menuItems) {
            if (isPremium) itemList.add(new PremiumItem(item));
            else itemList.add(new RegularItem(item));
        }
    }

    /*-----Getters-----*/
    public boolean isPremium() {
        return isPremium;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
}
