package org.pluralsight.shop;

import org.pluralsight.io.FileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Drink {
    public static void main(String[] args) {
        Drink drink = new Drink();
        drink.selectedDrink();
    }
    private Size size;

  public void drinkSize(Size size) {
      this.size = size;
  }
    private String flavor;

 public void drinkFlavor(String flavor) {
     this.flavor = flavor;
 }

 public void selectedDrink() {
     System.out.println("Select drink of choice: ");
     System.out.println("1) Small");
     System.out.println("2) Medium");
     System.out.println("3) Large");

     Scanner scanner = new Scanner(System.in);
     int sizeOptions = scanner.nextInt();

     switch (sizeOptions) {
         case 1:
             drinkSize(Size.SMALL);
             break;
         case 2:
             drinkSize(Size.MEDIUM);
             break;
         case 3:
             drinkSize(Size.LARGE);
             break;
         default: System.out.println("Invalid size");
     }
     // File manager method
     String relativePath = "Toppings/drinks.csv";
     String filePath = Paths.get(System.getProperty("user.dir"), relativePath).toString();
     FileManager fileManager = new FileManager(filePath);

     List<String> selectFlavor = flavorFromFile(fileManager.readFromFile("drinks.csv"));
     System.out.println("Select drink flavor:");
     int flavorChoice = scanner.nextInt();
     for (int i = 0; i < selectFlavor.size(); i++) {
         System.out.println((i + 1) + ") " + selectFlavor.get(i));
         if (flavorChoice >= 1 && flavorChoice <= selectFlavor.size()) {
             drinkFlavor(selectFlavor.get(flavorChoice - 1));
         } else {
             System.out.println("Invalid flavor choice.");
         }
     }


 }
    private List<String> flavorFromFile(String csvContent) {
        List<String> flavors = new ArrayList<>();

        // add flavors to the list
        String[] lines = csvContent.split("\n");
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length > 0) {
                flavors.add(parts[0]);
            }
        }

        return flavors;
    }

}
