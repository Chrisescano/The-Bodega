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

        FileManager fileManager = new FileManager("resource/menuItems/");
        File directory = new File("resource/menuItems");
        String[] menuItemFileNames = directory.list();

        assert menuItemFileNames != null; ////intellij required this, not sure why
        for (String fileName : menuItemFileNames) {
            String[] menuItems = fileManager.readFromFile(fileName).split("\n");
            for (String menuItem : menuItems) {
                itemType.add(fileName.substring(0, fileName.indexOf('.')));
                itemInformation.add(menuItem);
            }
        }
    }

    public String[] getItemInformation(String itemName) {
        for (int i = 0; i < itemInformation.size(); i++) {
            int indexOfPipe = itemInformation.get(i).indexOf("|");
            System.out.println(indexOfPipe);
            String name = itemInformation.get(i).substring(0, indexOfPipe);
            if (name.equalsIgnoreCase(itemName)) {
                return new String [] {itemType.get(i), itemInformation.get(i)};
            }
        }
        return null;
    }
}
