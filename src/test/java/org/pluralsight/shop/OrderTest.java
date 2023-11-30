package org.pluralsight.shop;

import org.junit.jupiter.api.Test;
import org.pluralsight.menuItems.Chip;
import org.pluralsight.menuItems.Drink;
import org.pluralsight.menuItems.Sandwich;

import static org.junit.jupiter.api.Assertions.*;


class OrderTest {

    @Test
    void addSandwich() {
        Sandwich sandwich = new Sandwich("BLT|10.50|medium|toasted|white|bacon|cheddar|tomato|ranch");
        assertEquals("BLT", sandwich.getName());
    }

    @Test
    void addChip() {
        Chip chip = new Chip("hot flamming|1.50|1.50|1.50");
        assertEquals("hot flamming", chip.getName());
    }

    @Test
    void addDrink() {
        Drink drink = new Drink("sprite|2.00|2.50|3.00");
        assertEquals("sprite", drink.getName());

    }

    @Test
    void removeItem() {
        Order order = new Order();
        Sandwich sandwich = new Sandwich("BLT|10.50|medium|toasted|white|bacon|cheddar|tomato|ranch");
        Chip chip = new Chip("hot flamming|1.50|1.50|1.50");
        Drink drink = new Drink("sprite|2.00|2.50|3.00");

        order.addSandwich(sandwich);
        order.addChip(chip);
        order.addDrink(drink);

        order.removeItem(1);

        System.out.println("removed: " + order);


    }

}
