package org.pluralsight.util;

import org.pluralsight.display.Displayable;
import org.pluralsight.menuItems.*;
import org.pluralsight.shop.Size;

import java.util.ArrayList;

public class MenuTable implements Displayable {
    private final StringBuilder menuTableBuilder;
    private final ArrayList<String> menuItems;
    private final TerminalFormat menuTableFormatter;

    public MenuTable(String menuType) {
        ItemManager itemManager = new ItemManager();

        menuItems = itemManager.getItemsByType(menuType);
        menuTableFormatter = new TerminalFormat();
        menuTableBuilder = new StringBuilder();

        //calculated lengths to fit table - 91 -> san25, dri32, chi32

        createHeader(menuType);
        menuTableBuilder.append(menuTableFormatter.divider());
        menuTableBuilder.append("\n");

        switch (menuType) {
            case "sandwiches" -> createTitle();
            case "drinks", "chips" -> createTitleForSizes();
        }

        for (String itemInfo : menuItems) {
            switch (menuType) {
                case "sandwiches" -> createSandwichRow(itemInfo);
                case "drinks" -> createDrinkRow(itemInfo);
                case "chips" -> createChipRow(itemInfo);
            }
        }

        menuTableBuilder.append(menuTableFormatter.divider());
        menuTableBuilder.append("\n");
    }

    public static void main(String[] args) {
        MenuTable table = new MenuTable("chips");
        table.run();
    }

    /*-----Private Methods-----*/
    private void createHeader(String item) {
        menuTableBuilder.append(menuTableFormatter.divider());
        menuTableBuilder.append("\n");
        menuTableBuilder.append(menuTableFormatter.tableRow(item, "center"));
        menuTableBuilder.append("\n");
    }

    private void createTitle() {
        menuTableBuilder.append(menuTableFormatter.tableRow("Price", "left"));
        menuTableBuilder.append("\n");
    }

    private void createTitleForSizes() {
        menuTableBuilder.append(menuTableFormatter.tableRow("S     M     L  ", "left"));
        menuTableBuilder.append("\n");
    }

    private void createSandwichRow(String itemInfo) {
        Sandwich sandwich = new Sandwich(itemInfo);
        menuTableBuilder.append(menuTableFormatter.tableRow(
                sandwich.getName(),
                String.format("$%4.2f", sandwich.getPrice()),
                "between"
        ));
        menuTableBuilder.append("\n");
    }

    private void createDrinkRow(String itemInfo) {
        Drink drink = new Drink(itemInfo);
        menuTableBuilder.append(menuTableFormatter.tableRow(
                drink.getName(), String.format(
                        "$%4.2f $%4.2f $%4.2f",
                        drink.getPrice(Size.SMALL),
                        drink.getPrice(Size.MEDIUM),
                        drink.getPrice(Size.LARGE)
                ), "between"
        ));
        menuTableBuilder.append("\n");
    }

    private void createChipRow(String itemInfo) {
        Chip chip = new Chip(itemInfo);
        menuTableBuilder.append(menuTableFormatter.tableRow(
                chip.getName(), String.format(
                        "$%4.2f $%4.2f $%4.2f",
                        chip.getPrice(Size.SMALL),
                        chip.getPrice(Size.MEDIUM),
                        chip.getPrice(Size.LARGE)
                ), "between"
        ));
        menuTableBuilder.append("\n");
    }

    @Override
    public void screen() {}

    @Override
    public void run() {
        System.out.println(menuTableBuilder);
    }
}