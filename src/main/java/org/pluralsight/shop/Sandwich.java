package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sandwich {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Sandwich s = new Sandwich();

        displayBreadOptions();
        System.out.println();

        displayCheeseToppings();
        System.out.println();

        displayMeatToppings();
        System.out.println();

        displayRegularToppings();
        System.out.println();

        displaySauceToppings();
        System.out.println();

        displaySideToppings();
        System.out.println();
    }

    private static ItemManager breadTypeIM;
    private static ItemManager cheeseIM;
    private static ItemManager meatIM;
    private static ItemManager regularIM;
    private static ItemManager sauceIM;
    private static ItemManager sideIM;

    public Sandwich() {
        breadTypeIM = new ItemManager("breads.csv", false);
        cheeseIM = new ItemManager("cheeses.csv", true);
        meatIM = new ItemManager("meats.csv", true);
        regularIM = new ItemManager("regular.csv", false);
        sauceIM = new ItemManager("sauces.csv", false);
        sideIM = new ItemManager("sides.csv", false);
    }

    // Once user select Sandwich, display bread types & it's available sizes,
    // prompt user to select a breadtype & its size
    public static void displayBreadOptions() {
        System.out.println("Bread Types & its Prices based on size ");
        for (int i = 0; i < breadTypeIM.getItemList().size(); i++) {
            breadTypeIM.getItemList().get(i).orderItem();

            System.out.println(breadTypeIM.getItemList().get(i).getItemName()
                    + " $" + breadTypeIM.getItemList().get(i).getPrice(Size.SMALL)
                    + " $" + breadTypeIM.getItemList().get(i).getPrice(Size.MEDIUM)
                    + " $" + breadTypeIM.getItemList().get(i).getPrice(Size.LARGE)
            );
        }

        // displaySizes();
    }

    // displaying sizes from Size enum class
    public static void displaySizes() {
        System.out.println("Available sizes: ");
        for (Size size : Size.values()) {
            System.out.println(size);
        }
    }
    public static void displayCheeseToppings() {
        System.out.println("Cheese Toppings & its Prices based on size ");
        for (int i = 0; i < cheeseIM.getItemList().size(); i++) {
            cheeseIM.getItemList().get(i).orderItem();

            System.out.println(cheeseIM.getItemList().get(i).getItemName()
                    + " $" + cheeseIM.getItemList().get(i).getPrice(Size.SMALL)
                    + " $" + cheeseIM.getItemList().get(i).getPrice(Size.MEDIUM)
                    + " $" + cheeseIM.getItemList().get(i).getPrice(Size.LARGE)
            );
        }
    }
    public static void displayMeatToppings() {
        System.out.println("Meat Toppings & its Prices based on size ");
        for (int i = 0; i < meatIM.getItemList().size(); i++) {
            meatIM.getItemList().get(i).orderItem();

            System.out.println(meatIM.getItemList().get(i).getItemName()
                    + " $" + meatIM.getItemList().get(i).getPrice(Size.SMALL)
                    + " $" + meatIM.getItemList().get(i).getPrice(Size.MEDIUM)
                    + " $" + meatIM.getItemList().get(i).getPrice(Size.LARGE)
            );
        }
    }
    public static void displayRegularToppings() {
        System.out.println("Regular Toppings & its Prices based on size ");
        for (int i = 0; i < regularIM.getItemList().size(); i++) {
            regularIM.getItemList().get(i).orderItem();

            System.out.println(regularIM.getItemList().get(i).getItemName()
                    + " $" + regularIM.getItemList().get(i).getPrice(Size.SMALL)
                    + " $" + regularIM.getItemList().get(i).getPrice(Size.MEDIUM)
                    + " $" + regularIM.getItemList().get(i).getPrice(Size.LARGE)
            );
        }
    }
    public static void displaySauceToppings() {
        System.out.println("Sauce Toppings & its Prices based on size ");
        for (int i = 0; i < sauceIM.getItemList().size(); i++) {
            sauceIM.getItemList().get(i).orderItem();

            System.out.println(sauceIM.getItemList().get(i).getItemName()
                    + " $" + sauceIM.getItemList().get(i).getPrice(Size.SMALL)
                    + " $" + sauceIM.getItemList().get(i).getPrice(Size.MEDIUM)
                    + " $" + sauceIM.getItemList().get(i).getPrice(Size.LARGE)
            );
        }
    }
    public static void displaySideToppings() {
        System.out.println("Side Toppings & its Prices based on size ");
        for (int i = 0; i < sideIM.getItemList().size(); i++) {
            sideIM.getItemList().get(i).orderItem();

            System.out.println(sideIM.getItemList().get(i).getItemName()
                    + " $" + sideIM.getItemList().get(i).getPrice(Size.SMALL)
                    + " $" + sideIM.getItemList().get(i).getPrice(Size.MEDIUM)
                    + " $" + sideIM.getItemList().get(i).getPrice(Size.LARGE)
            );
        }
    }





}

/* Sandwich class
* Get breadtype
* Prompt user for breadsize
    * Get breadsize
* Prompt user for Regular toppings or Premium Toppings
    * Get toppings
* */
