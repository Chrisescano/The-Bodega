package org.pluralsight.io;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    public void readFromFileTest() {
        FileManager fileManager = new FileManager("Toppings/");
        FileManager resourcesFileManager = new FileManager("src/test/resources/");

        String breadsFile = fileManager.readFromFile("breads.csv");
        String resourceFile = resourcesFileManager.readFromFile("testBreads.csv");
        assertEquals(breadsFile, resourceFile);
    }

    @Test
    public void writeFromFileTest() {
        FileManager fileManager = new FileManager("src/test/resources/");
        String resourceFile = fileManager.readFromFile("testBreads.csv");

        fileManager.writeToFile("copyBreads.csv", resourceFile);
        String copyFile = fileManager.readFromFile("copyBreads.csv");
        assertEquals(resourceFile, copyFile);
    }
}