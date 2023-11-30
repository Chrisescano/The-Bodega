package org.pluralsight.topping;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class ToppingManagerTest {

    @Test
    void getTopping() {
        ToppingManager toppingManager = new ToppingManager();
        Topping topping = toppingManager.getTopping("white");
        assertEquals("white", topping.getName());
        assertEquals(5.50, topping.getPrice(Size.SMALL));
        assertEquals(7.00, topping.getPrice(Size.MEDIUM));
        assertEquals(8.50, topping.getPrice(Size.LARGE));
    }
}