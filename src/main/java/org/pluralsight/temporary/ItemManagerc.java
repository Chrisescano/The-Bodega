package org.pluralsight.temporary;

import org.pluralsight.io.FileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ItemManagerc {
    ArrayList<String> itemList;

    public ItemManagerc() {
        itemList = new ArrayList<>();

        FileManager fileManager = new FileManager("resources/menuItems");
        String[] menuItemFileNames = new File("resources/menuItems").list();

        assert menuItemFileNames != null; ////intellij required this, not sure why
        for (String fileName : menuItemFileNames) {
            String[] menuItems = fileManager.readFromFile(fileName).split("\n");
            Collections.addAll(itemList, menuItems); //intellij recommendation
        }
    }

    public ArrayList<String> getItemList() {
        return itemList;
    }
}
