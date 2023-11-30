package org.pluralsight.menuItems;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void addTopping() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|medium|toasted|white");
        sandwich.addTopping("lettuce");
        assertEquals("lettuce", sandwich.getSandwichToppings().get(1).getName());
    }

    @Test
    void removeTopping() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|medium|toasted|white");
        sandwich.addTopping("lettuce");
        sandwich.removeTopping("white");
        assertEquals("lettuce", sandwich.getSandwichToppings().get(0).getName());
    }

    @Test
    void isToasted() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|medium|toasted|white");
        assertTrue(sandwich.isToasted());
    }

    @Test
    void setToasted() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|medium|toasted|white");
        sandwich.setToasted(false);
        assertFalse(sandwich.isToasted());
    }

    @Test
    void getPrice() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|medium|toasted|white");
        assertEquals(0, sandwich.getPrice(Size.LARGE));
    }

    @Test
    void testGetPrice() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|medium|toasted|white");
        assertEquals(7.00, sandwich.getPrice());
    }

    @Test
    void getSize() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|large|toasted|white");
        assertEquals(Size.LARGE, sandwich.getSize());
    }
}