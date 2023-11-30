package org.pluralsight.menuItems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {

    @Test
    void getItemInformation() {
        ItemManager itemManager = new ItemManager();
        String[] itemInfo = itemManager.getItemInformation("BLT");
        assertEquals("sandwiches", itemInfo[0]);
        assertEquals("BLT|10.50|medium|toasted|white|bacon|cheddar|tomato|ranch", itemInfo[1]);
    }
}