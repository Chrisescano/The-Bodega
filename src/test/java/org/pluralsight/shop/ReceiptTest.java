package org.pluralsight.shop;

import org.junit.jupiter.api.Test;
import org.pluralsight.io.FileManager;
import org.pluralsight.shop.Receipt;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    void buildReceiptHeader() {
        Receipt receipt = new Receipt();
        assertEquals("""
                +------------------------------------------+
                |                 The Deli                 |
                +------------------------------------------+
                |            phone 123-456-7890            |
                |              123 Maiden LN               |
                |             County, NY 12345             |
                +------------------------------------------+
                | QTY ITEM                           PRICE |
                | --- ----                           ----- |
                """, receipt.toString());
    }

    @Test
    void addLine() {
        Receipt receipt = new Receipt();
        receipt.addLine("1", "Build Your Own", "$5.00");
        assertEquals("""
                +------------------------------------------+
                |                 The Deli                 |
                +------------------------------------------+
                |            phone 123-456-7890            |
                |              123 Maiden LN               |
                |             County, NY 12345             |
                +------------------------------------------+
                | QTY ITEM                           PRICE |
                | --- ----                           ----- |
                |   1 Build Your Own                 $5.00 |
                """, receipt.toString());
    }

    @Test
    void testAddLine() {
        Receipt receipt = new Receipt();
        receipt.addLine("Ham", "$5.00");
        assertEquals("""
                +------------------------------------------+
                |                 The Deli                 |
                +------------------------------------------+
                |            phone 123-456-7890            |
                |              123 Maiden LN               |
                |             County, NY 12345             |
                +------------------------------------------+
                | QTY ITEM                           PRICE |
                | --- ----                           ----- |
                |     Ham                            $5.00 |
                """, receipt.toString());
    }

    @Test
    void addDivider() {
        Receipt receipt = new Receipt();
        receipt.addDivider();
        assertEquals("""
                +------------------------------------------+
                |                 The Deli                 |
                +------------------------------------------+
                |            phone 123-456-7890            |
                |              123 Maiden LN               |
                |             County, NY 12345             |
                +------------------------------------------+
                | QTY ITEM                           PRICE |
                | --- ----                           ----- |
                +------------------------------------------+
                """, receipt.toString());
    }

    @Test
    void save() {
        Receipt receipt = new Receipt();
        receipt.save();

        FileManager fileManager = new FileManager("Receipts/");
        String fileContents = fileManager.readFromFile("20231128-1138.txt");
        assertEquals("""
                +------------------------------------------+
                |                 The Deli                 |
                +------------------------------------------+
                |            phone 123-456-7890            |
                |              123 Maiden LN               |
                |             County, NY 12345             |
                +------------------------------------------+
                | QTY ITEM                           PRICE |
                | --- ----                           ----- |
                """, fileContents);
    }

    @Test
    void testToString() {
        Receipt receipt = new Receipt();
        assertEquals("""
                +------------------------------------------+
                |                 The Deli                 |
                +------------------------------------------+
                |            phone 123-456-7890            |
                |              123 Maiden LN               |
                |             County, NY 12345             |
                +------------------------------------------+
                | QTY ITEM                           PRICE |
                | --- ----                           ----- |
                """, receipt.toString());
    }
}