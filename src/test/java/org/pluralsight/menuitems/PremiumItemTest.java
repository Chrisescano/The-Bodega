package org.pluralsight.menuitems;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class PremiumItemTest {

    @Test
    void isExtraOrdered() {
        PremiumItem premiumItem = new PremiumItem("steak|1.00|2.00|3.00|0.50|1.00|1.50");
        assertFalse(premiumItem.isExtraOrdered());
    }

    @Test
    void getItemName() {
        PremiumItem premiumItem = new PremiumItem("steak|1.00|2.00|3.00|0.50|1.00|1.50");
        assertEquals(premiumItem.getItemName(), "steak");
    }

    @Test
    void getPrice() {
        PremiumItem premiumItem = new PremiumItem("steak|1.00|2.00|3.00|0.50|1.00|1.50");
        assertEquals(1.00, premiumItem.getPrice(Size.SMALL));
        assertEquals(2.00, premiumItem.getPrice(Size.MEDIUM));
        assertEquals(3.00, premiumItem.getPrice(Size.LARGE));

        premiumItem.setExtraOrdered(true);
        assertEquals(1.50, premiumItem.getPrice(Size.SMALL));
        assertEquals(3.00, premiumItem.getPrice(Size.MEDIUM));
        assertEquals(4.50, premiumItem.getPrice(Size.LARGE));
    }

    @Test
    void setExtraOrdered() {
        PremiumItem premiumItem = new PremiumItem("steak|1.00|2.00|3.00|0.50|1.00|1.50");
        premiumItem.setExtraOrdered(true);
        assertTrue(premiumItem.isExtraOrdered());
    }
}