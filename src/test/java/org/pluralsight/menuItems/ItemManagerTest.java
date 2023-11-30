package org.pluralsight.menuItems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {

    @Test
    void getItemInformation() {
        ItemManager itemManager = new ItemManager();
        String[] itemInfo = itemManager.getItemInformation("BLT");
        assertEquals("sandwiches", itemInfo[0]);
        assertEquals("BLT|10.50|medium|toasted|white|bacon|cheddar|tomato|ranch", itemInfo[1]);
    }

    @Test
    void getItemInfoByType() {
        ItemManager itemManager = new ItemManager();
        ArrayList<String> itemsByType = itemManager.getItemInfoByType("sandwiches");

        assertEquals("Philly Cheese Steak|10.50||medium|toasted|white|steak|american|peppers|mayo", itemsByType.get(2));
    }
}