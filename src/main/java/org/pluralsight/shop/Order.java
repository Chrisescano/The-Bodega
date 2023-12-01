package org.pluralsight.shop;

import org.pluralsight.menuItems.Chip;
import org.pluralsight.menuItems.Drink;
import org.pluralsight.menuItems.Item;
import org.pluralsight.menuItems.Sandwich;
import org.pluralsight.topping.Topping;
import org.pluralsight.util.TerminalFormat;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Item> items;
    Receipt receipt;
    private double price;
    TerminalFormat format;
    StringBuilder orderBuilder;

    public Order() {
        items = new ArrayList<>();
        receipt = new Receipt();
        price = 0;
        format = new TerminalFormat();
        orderBuilder = new StringBuilder();

    }

    public void addSandwich(Sandwich sandwich) {
        items.add(sandwich);
    }

    public void addChip(Chip chip) {
        items.add(chip);
    }

    public void addDrink(Drink drink) {
        items.add(drink);
    }

    public void printOrder() {
        receipt = new Receipt();

        orderBuilder.append(format.divider());
        orderBuilder.append("\n");
        for (Item item : items) {
            orderBuilder.append(item.print());
            orderBuilder.append(format.divider());
            orderBuilder.append("\n");
            price += item.getPrice();
        }

        orderBuilder.append(format.tableRow("Total", String.valueOf(price), "between"));
        orderBuilder.append("\n");
        orderBuilder.append(format.divider());
        System.out.println(orderBuilder);
    }

    public void save() {
        receipt.appendToReceipt(orderBuilder.toString());
        receipt.save();
    }

    /*-----Getter-----*/
    public double getPrice() {
        return price;
    }
}
