package org.pluralsight.menuItems;

import org.pluralsight.io.FileManager;

import java.io.File;
import java.util.ArrayList;

public class ItemManager {
    private final ArrayList<String> itemType;
    private final ArrayList<String> itemInformation;

    public ItemManager() {
        itemType = new ArrayList<>();
        itemInformation = new ArrayList<>();

        FileManager fileManager = new FileManager("resources/menuItems");
        String[] menuItemFileNames = new File("resources/menuItems").list();

        assert menuItemFileNames != null; ////intellij required this, not sure why
        for (String fileName : menuItemFileNames) {
            String[] menuItems = fileManager.readFromFile(fileName).split("\n");
            for (String menuItem : menuItems) {
                itemType.add(fileName);
                itemInformation.add(menuItem);
            }
        }
    }

    //ability to get item info from what the constructor did
}
