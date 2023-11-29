package org.pluralsight.shop;

import org.pluralsight.menuitems.Item;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Sandwich> sandwiches;
    private final ArrayList<Drink> drinks;
    private final ArrayList<Chip> chips;
    private final Receipt receipt;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        receipt = new Receipt();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public void printOrder() {
        for (Sandwich sandwich : sandwiches) {
            String isToasted = sandwich.isToasted() ? "Toasted" : "Regular";
            receipt.addLine("1", "BYO " + isToasted, String.valueOf(sandwich.getPrice()));
            for (Item item : sandwich.getSandwichItems()) {
                receipt.addLine(
                        item.getItemName(),
                        String.valueOf(item.getPrice(sandwich.getBreadSize())));
            }
        }



        receipt.addDivider();
        System.out.println(receipt);

        /*
        Todo:
        - loop for drinks
        - loop for chips
         */
    }

    public void saveOrder() {
        receipt.save();
    }
}
