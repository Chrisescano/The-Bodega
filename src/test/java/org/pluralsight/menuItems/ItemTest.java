package org.pluralsight.menuItems;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getItemName() {
        Item item = new Item("plain|1.50|1.50|1.50") {
            @Override
            public double getPrice(Size size) {
                return 0;
            }

            @Override
            protected double getPrice() {
                return 0;
            }
        };

        assertEquals(null, item.getName());
    }

    @Test
    void getPrice() {
        Item item = new Item("plain|1.50|1.50|1.50") {
            @Override
            public double getPrice(Size size) {
                return 0;
            }

            @Override
            protected double getPrice() {
                return 0;
            }
        };

        assertEquals(0, item.getPrice());
    }

    @Test
    void testGetPrice() {
        Item item = new Item("plain|1.50|1.50|1.50") {
            @Override
            public double getPrice(Size size) {
                return 0;
            }

            @Override
            protected double getPrice() {
                return 0;
            }
        };
        assertEquals(0, item.getPrice(Size.SMALL));
        assertEquals(0, item.getPrice(Size.MEDIUM));
        assertEquals(0, item.getPrice(Size.LARGE));
    }
}