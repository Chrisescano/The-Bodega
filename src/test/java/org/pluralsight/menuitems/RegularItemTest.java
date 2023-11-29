package org.pluralsight.menuitems;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class RegularItemTest {

    @Test
    void getItemNameTest() {
        RegularItem regularItem = new RegularItem("lettuce|0.00|0.00|0.00");
        assertEquals("lettuce", regularItem.getItemName());
    }

    @Test
    void getPriceTest() {
        RegularItem regularItem = new RegularItem("lettuce|0.00|0.00|0.00");
        assertEquals(0.00, regularItem.getPrice(Size.SMALL));
        assertEquals(0.00, regularItem.getPrice(Size.MEDIUM));
        assertEquals(0.00, regularItem.getPrice(Size.LARGE));
    }
}