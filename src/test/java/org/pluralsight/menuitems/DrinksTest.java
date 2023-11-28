package org.pluralsight.menuitems;
import org.junit.Before;
import org.junit.Test;
import org.pluralsight.shop.Drink;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class DrinksTest {
    private Drink drink;

    @Before
    public void setUp() {
        drink = new Drink();
    }

    @Test

    public void testSelectedDrinkWithDifferentOptions() {
        String expectedOutput = "1. coca cola\n2. pepsi\n3. dr pepper\n4. fanta\n5. sprite\n6. jarrito lime\n7. root beer";
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(expectedOutput, getConsoleOutput());

        System.setIn(System.in);
    }



    private String getConsoleOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        drink.selectedDrink();
        System.setOut(System.out);
        return outContent.toString().trim();
    }

}
