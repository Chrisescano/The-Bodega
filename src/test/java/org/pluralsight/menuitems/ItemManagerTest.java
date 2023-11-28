package org.pluralsight.menuitems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemManagerTest {

    @Test
    void isPremium() {
        ItemManager itemManager = new ItemManager("meats.csv", false);
        assertFalse(itemManager.isPremium());

        ItemManager itemManager1 = new ItemManager("meats.csv", true);
        assertTrue(itemManager1.isPremium());
    }

    @Test
    void getItemList() {
        ItemManager itemManager = new ItemManager("meats.csv", true);
        assertEquals(6, itemManager.getItemList().size());
    }
}