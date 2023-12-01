package org.pluralsight.topping;

import org.pluralsight.io.FileManager;

import java.io.File;
import java.util.ArrayList;

public class ToppingManager {
    private final ArrayList<Topping> toppingsList;

    public ToppingManager() {
        toppingsList = new ArrayList<>();
        FileManager fileManager = new FileManager("resource/toppings/");
        File directory = new File("resource/toppings");
        String[] toppingFileNames = directory.list();

        assert toppingFileNames != null;
        for (String fileName : toppingFileNames) {
            String[] toppings = fileManager.readFromFile(fileName).split("\n");
            for (String topping : toppings) {
                String toppingType = fileName.substring(0, fileName.indexOf('.'));
                switch (fileName) {
                    case "meats.csv", "cheese.csv" -> toppingsList.add(new PremiumTopping(topping, toppingType));
                    default -> toppingsList.add(new RegularTopping(topping, toppingType));
                }
            }
        }
    }

    public Topping getTopping(String nameOfTopping) {
        for (Topping topping : toppingsList) {
            if (topping.getName().equalsIgnoreCase(nameOfTopping)) {
                return topping;
            }
        }
        return null;
    }

    public ArrayList<Topping> getToppingList() {
        return toppingsList;
    }
}
