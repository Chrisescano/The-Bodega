package org.pluralsight.menuItems;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;
import org.pluralsight.topping.RegularTopping;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void addTopping() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|medium|toasted|white");
        RegularTopping regularTopping = new RegularTopping("lettuce|0.00|0.00|0.00", "regular");
        sandwich.addTopping(regularTopping);
        assertEquals("lettuce", sandwich.getSandwichToppings().get(1).getName());
    }

    @Test
    void removeTopping() {
        Sandwich sandwich = new Sandwich("Build Your Own|7.00|medium|toasted|white");
        RegularTopping regularTopping = new RegularTopping("lettuce|0.00|0.00|0.00", "regular");
        sandwich.addTopping(regularTopping);
        RegularTopping regularTopping1 = new RegularTopping("white|5.50|7.00|8.50", "breads");
        sandwich.removeTopping(regularTopping1);
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

    @Test
    void printSandwichToppingsTest() {
        Sandwich sandwich = new Sandwich("BLT|10.50|medium|toasted|white|bacon|cheddar|tomatoes|ranch");
        assertEquals(
                "[ white ][ bacon ][ cheddar ][ tomatoes ][ ranch ]",
                sandwich.toString()
        );
    }
}