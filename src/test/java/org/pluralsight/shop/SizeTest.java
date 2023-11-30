package org.pluralsight.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeTest {

    @Test
    void getBreadSize() {
        assertEquals("4\"", Size.SMALL.getBreadSize());
        assertEquals("8\"", Size.MEDIUM.getBreadSize());
        assertEquals("12\"", Size.LARGE.getBreadSize());
    }

    @Test
    void values() {
        Size[] sizes = Size.values();
        assertEquals(3, sizes.length);
        assertEquals(Size.SMALL, sizes[0]);
        assertEquals(Size.MEDIUM, sizes[1]);
        assertEquals(Size.LARGE, sizes[2]);

    }


}