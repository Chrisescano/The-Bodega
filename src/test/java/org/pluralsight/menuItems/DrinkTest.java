package org.pluralsight.menuItems;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void getPrice() {
        Drink drink = new Drink("coca cola|2.00|2.50|3.00");
        assertEquals(0, drink.getPrice());
    }

    @Test
    void testGetPrice() {
        Drink drink = new Drink("coca cola|2.00|2.50|3.00");
        assertEquals(2.00, drink.getPrice(Size.SMALL));
        assertEquals(2.50, drink.getPrice(Size.MEDIUM));
        assertEquals(3.00, drink.getPrice(Size.LARGE));
    }
}