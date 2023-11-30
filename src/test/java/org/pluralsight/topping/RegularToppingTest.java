package org.pluralsight.topping;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class RegularToppingTest {

    @Test
    void getPrice() {
        RegularTopping regularTopping = new RegularTopping("white|5.50|7.00|8.50", "bread");
        assertEquals(5.50, regularTopping.getPrice(Size.SMALL));
        assertEquals(7.00, regularTopping.getPrice(Size.MEDIUM));
        assertEquals(8.50, regularTopping.getPrice(Size.LARGE));
    }
}