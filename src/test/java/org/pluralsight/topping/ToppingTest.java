package org.pluralsight.topping;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {

    @Test
    void setExtraOrdered() {
        RegularTopping topping = new RegularTopping("white|5.50|7.00|8.50", "bread");
        topping.setExtraOrdered(true);
        assertTrue(topping.isExtraOrdered());
    }

    @Test
    void getName() {
        RegularTopping topping = new RegularTopping("white|5.50|7.00|8.50", "bread");
        assertEquals("white", topping.getName());
    }

    @Test
    void isExtraOrdered() {
        RegularTopping topping = new RegularTopping("white|5.50|7.00|8.50", "bread");
        assertFalse(topping.isExtraOrdered());
    }

    @Test
    void getPrice() {
        RegularTopping topping = new RegularTopping("white|5.50|7.00|8.50", "bread");
        assertEquals(5.50, topping.getPrice(Size.SMALL));
        assertEquals(7.00, topping.getPrice(Size.MEDIUM));
        assertEquals(8.50, topping.getPrice(Size.LARGE));
    }
}