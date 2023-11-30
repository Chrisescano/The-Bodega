package org.pluralsight.util;

import org.pluralsight.display.Displayable;
import org.pluralsight.menuItems.Chip;
import org.pluralsight.menuItems.Drink;
import org.pluralsight.menuItems.ItemManager;
import org.pluralsight.menuItems.Sandwich;
import org.pluralsight.shop.Size;

import java.util.ArrayList;

public class MenuTable implements Displayable {
    private final ItemManager itemManager;
    private final ArrayList<String> sandwiches;
    private final ArrayList<String> chips;
    private final ArrayList<String> drinks;
    private final StringBuilder menuTableBuilder;
    private final TerminalFormat tableHeader = new TerminalFormat();
    private final TerminalFormat sandwichSection = new TerminalFormat();
    private final TerminalFormat drinkSection = new TerminalFormat();
    private final TerminalFormat chipSection = new TerminalFormat();
    /*
     * row sandwiches:
     *   [name of sandwich] (19) + 1 char space
     *   [$xx.xx] (5)
     *   total = 19 + 1 + 5 = 25 chars
     *
     * row drinks:
     *   [name of drinks] (10) + 1 char space
     *   [$xx.xx] (5) x 3 -> 1 pade of space between each (2)
     *   total = 10 + 1 + 15 + 2 = 27 chars
     *
     * row chips:
     *   {same as drinks} = 27 chars
     *
     * total for all:
     *   25 + 27 + 27 -> for each terminal formatter
     *
     * table header:
     *   25 + 27 + 27 + 2= 81 chars
     */
    public MenuTable() {
        itemManager = new ItemManager();
        sandwiches = itemManager.getItemsByType("sandwiches");
        chips = itemManager.getItemsByType("chips");
        drinks = itemManager.getItemsByType("drinks");
        menuTableBuilder = new StringBuilder();

        tableHeader.setWidth(91);
        sandwichSection.setWidth(25);
        drinkSection.setWidth(32);
        chipSection.setWidth(32);

        int max = Math.max(Math.max(drinks.size(), chips.size()), sandwiches.size());

        createHeader();
        createBodyDivider();
        createBodyTitle();
        for (int i = 0; i < max; i++) {
            createBodyRow(i);
        }
        createBodyDivider();
    }

    public static void main(String[] args) {
        MenuTable menuTable = new MenuTable();
        menuTable.run();
    }

    /*-----Private Methods-----*/
    private void createHeader() {
        menuTableBuilder.append(tableHeader.divider());
        menuTableBuilder.append("\n");
        menuTableBuilder.append(tableHeader.tableRow("Menu Options", "center"));
        menuTableBuilder.append("\n");
    }

    private void createBodyDivider() {
        String sandwichDivider = sandwichSection.divider();
        String chipDivider = chipSection.divider();
        sandwichDivider = sandwichDivider.substring(0, sandwichDivider.length() - 3);
        chipDivider = chipDivider.substring(3);

        menuTableBuilder.append(sandwichDivider);
        menuTableBuilder.append(drinkSection.divider());
        menuTableBuilder.append(chipDivider);
        menuTableBuilder.append("\n");
    }

    private void createBodyTitle() {
        String sandwichTitle = sandwichSection.tableRow("Price   ", "left");
        String drinksTitle = drinkSection.tableRow(String.format(
                "%s     %s     %s  ", "S", "M", "L"
        ), "left");
        String chipsTitle = chipSection.tableRow(String.format(
                "%s     %s     %s  ", "S", "M", "L"
        ), "left");


        sandwichTitle = sandwichTitle.substring(0, sandwichTitle.length() - 3);
        chipsTitle = chipsTitle.substring(3);

        menuTableBuilder.append(sandwichTitle);
        menuTableBuilder.append(drinksTitle);
        menuTableBuilder.append(chipsTitle);
        menuTableBuilder.append("\n");
    }

    private void createBodyRow(int row) {
        createSandwichSectionRow(row);
        createDrinkSectionRow(row);
        createChipSection(row);
        menuTableBuilder.append("\n");
    }

    /*-----Helper Methods-----*/

    private void createSandwichSectionRow(int row) {
        String sandwichInfo = null;
        try {
            Sandwich sandwich = new Sandwich(sandwiches.get(row));
            sandwichInfo = sandwichSection.tableRow(String.format(
                    "%-16.16s $%4.2f", sandwich.getName(), sandwich.getPrice()), "right"
            );
        } catch (IndexOutOfBoundsException e) {
            sandwichInfo = sandwichSection.tableRow();
        }
        sandwichInfo = sandwichInfo.substring(0, sandwichInfo.length() - 3);
        menuTableBuilder.append(sandwichInfo);
    }

    private void createDrinkSectionRow(int row) {
        try {
            Drink drink = new Drink(drinks.get(row));
            menuTableBuilder.append(drinkSection.tableRow(
                    String.format("%-14.14s $%4.2f $%4.2f $%4.2f",
                            drink.getName(),
                            drink.getPrice(Size.SMALL),
                            drink.getPrice(Size.MEDIUM),
                            drink.getPrice(Size.LARGE)),
                    "right"
            ));
        } catch (IndexOutOfBoundsException e) {
            menuTableBuilder.append(drinkSection.tableRow());
        }
    }

    private void createChipSection(int row) {
        String chipInfo = null;
        try {
            Chip chip = new Chip(chips.get(row));
            chipInfo = drinkSection.tableRow(
                    String.format("%-12.12s $%4.2f $%4.2f $%4.2f",
                            chip.getName(),
                            chip.getPrice(Size.SMALL),
                            chip.getPrice(Size.MEDIUM),
                            chip.getPrice(Size.LARGE)),
                    "left"
            );
        } catch (IndexOutOfBoundsException e) {
            chipInfo = chipSection.tableRow();
        }
        chipInfo = chipInfo.substring(3);
        menuTableBuilder.append(chipInfo);
    }

    @Override
    public void screen() {}

    @Override
    public void run() {
        System.out.println(menuTableBuilder);
    }
}