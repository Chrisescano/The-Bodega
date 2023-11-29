package org.pluralsight.shop;

import org.junit.jupiter.api.Test;
import org.pluralsight.menuitems.ItemManager;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void getItemManager() {
        ItemManager itemManager = new ItemManager("breads.csv", false);
        assertEquals("b", itemManager.getItemList());
    }
}