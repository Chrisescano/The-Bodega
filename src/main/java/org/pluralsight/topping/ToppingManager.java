package org.pluralsight.topping;

import org.pluralsight.io.FileManager;

import java.io.File;
import java.util.ArrayList;

public class ToppingManager {
    ArrayList<Topping> toppingsList;

    public ToppingManager() {
        toppingsList = new ArrayList<>();
        FileManager fileManager = new FileManager("resource/toppings/");
        File directory = new File("resource/toppings");
        String[] toppingFileNames = directory.list();

        assert toppingFileNames != null; //intellij required this, not sure why
        for (String fileName : toppingFileNames) {
            String[] toppings = fileManager.readFromFile(fileName).split("\n");
            for (String topping : toppings) {
                switch (fileName) {
                    case "meats.csv", "cheese.csv" -> toppingsList.add(new PremiumTopping(topping));
                    default -> toppingsList.add(new RegularTopping(topping));
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
}
