package org.pluralsight.menuItems;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class ChipTest {

    @Test
    void getPrice() {
        Chip chip = new Chip("plain|1.50|1.50|1.50");
        assertEquals(0, chip.getPrice());
    }

    @Test
    void testGetPrice() {
        Chip chip = new Chip("plain|1.50|1.50|1.50");
        assertEquals(1.50, chip.getPrice(Size.SMALL));
        assertEquals(1.50, chip.getPrice(Size.MEDIUM));
        assertEquals(1.50, chip.getPrice(Size.LARGE));
    }
}