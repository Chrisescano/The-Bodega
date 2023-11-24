package org.pluralsight.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    public void readFromFileTest() {
        FileManager fileManager = new FileManager();
        String breadsFile = fileManager.readFromFile("Toppings/breads.csv");
        String resourceFile = fileManager.readFromFile("src/test/resources/testBreads.csv");
        assertEquals(breadsFile, resourceFile);
    }

    @Test
    public void writeFromFileTest() {
        FileManager fileManager = new FileManager();
        String resourceFile = fileManager.readFromFile("src/test/resources/testBreads.csv");

        fileManager.writeToFile("src/test/resources/copyBreads.csv", resourceFile);
        String copyFile = fileManager.readFromFile("src/test/resources/copyBreads.csv");
        assertEquals(resourceFile, copyFile);
    }
}