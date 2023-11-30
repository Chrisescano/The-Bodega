package org.pluralsight.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ScannerIOTest {
    private ByteArrayInputStream testInput;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getStringInput() {
        String input = "Test Input\n";
        testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        String result = ScannerIO.getStringInput("Enter something: ");

        assertEquals("Test Input", result);

    }

    @Test
    void getIntInput() {
        String input = "2\n";
        testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        int result = ScannerIO.getIntInput("Enter : ");

        assertEquals(2, result);
    }

    @Test
    void getBooleanInput() {
        String input = "YES\n";
        testInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(testInput);

        boolean result = ScannerIO.getBooleanInput("Enter yes or no: ");

        assertTrue(result);
    }
}