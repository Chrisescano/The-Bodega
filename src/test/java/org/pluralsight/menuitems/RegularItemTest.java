package org.pluralsight.menuitems;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class RegularItemTest {

    @Test
    void getItemNameTest() {
        RegularItem regularItem = new RegularItem("lettuce|0.00|0.00|0.00");
        assertEquals(regularItem.getItemName(), "lettuce");
    }

    @Test
    void getPriceTest() {
        RegularItem regularItem = new RegularItem("lettuce|0.00|0.00|0.00");
        assertEquals(regularItem.getPrice(Size.SMALL), 0.00);
        assertEquals(regularItem.getPrice(Size.MEDIUM), 0.00);
        assertEquals(regularItem.getPrice(Size.LARGE), 0.00);
    }
}