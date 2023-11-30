package org.pluralsight.topping;

import org.junit.jupiter.api.Test;
import org.pluralsight.shop.Size;

import static org.junit.jupiter.api.Assertions.*;

class PremiumToppingTest {

    @Test
    void getPrice() {
        PremiumTopping premiumTopping = new PremiumTopping("american|0.75|1.50|2.25|0.30|0.60|0.90", "cheese");
        assertEquals(0.75, premiumTopping.getPrice(Size.SMALL));
        assertEquals(1.50, premiumTopping.getPrice(Size.MEDIUM));
        assertEquals(2.25, premiumTopping.getPrice(Size.LARGE));

        premiumTopping.setExtraOrdered(true);
        assertEquals(1.05, premiumTopping.getPrice(Size.SMALL));
        assertEquals(2.10, premiumTopping.getPrice(Size.MEDIUM));
        assertEquals(3.15, premiumTopping.getPrice(Size.LARGE));
    }
}