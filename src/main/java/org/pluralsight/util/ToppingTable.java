package org.pluralsight.util;

import org.pluralsight.display.Displayable;
import org.pluralsight.shop.Size;
import org.pluralsight.topping.Topping;
import org.pluralsight.topping.ToppingManager;

import java.util.ArrayList;

public class ToppingTable implements Displayable {
    TerminalFormat tableHeader;
    TerminalFormat tableBodySections;
    StringBuilder toppingTableBuilder;

    public ToppingTable() {
        ToppingManager toppingManager = new ToppingManager();
        tableHeader = new TerminalFormat();
        tableBodySections = new TerminalFormat();
        toppingTableBuilder = new StringBuilder();

        int maxWidth = findMaxWidth(toppingManager.getToppingList());
        tableHeader.setWidth(maxWidth * 4 + 9);
        tableBodySections.setWidth(maxWidth);

        buildTableHeader("Toppings");
        buildUniqueToppingSection(toppingManager.getToppingList());
        buildTableDivider();
    }

    public static void main(String[] args) {
        ToppingTable toppingTable = new ToppingTable();
        toppingTable.run();
    }

    /*-----Private Methods-----*/
    private void buildTableHeader(String text) {
        toppingTableBuilder.append(tableHeader.divider());
        toppingTableBuilder.append("\n");
        toppingTableBuilder.append(tableHeader.tableRow(
                text, "center"
        ));
        toppingTableBuilder.append("\n");
    }

    private void buildTableDivider() {
        for (int i = 0; i < 4; i++) {
            String divider = tableBodySections.divider();
            divider = divider.substring(0, divider.length() - 1);
            toppingTableBuilder.append(divider);
        }
        toppingTableBuilder.append(tableBodySections.getAnchorDivider());
        toppingTableBuilder.append("\n");
    }

    private void buildUniqueToppingSection(ArrayList<Topping> toppings) {
        String uniqueID = toppings.get(0).getType();
        buildTableHeader(uniqueID);

        for (Topping topping : toppings) {
            if (topping.getType().equalsIgnoreCase(uniqueID)) {
                buildTableRow(topping);
            } else {
                uniqueID = topping.getType();
                buildTableHeader(uniqueID);
                buildTableRow(topping);
            }
        }
    }

    private void buildTableRow(Topping topping) {
        toppingTableBuilder.append(tableBodySections.tableRow(
                topping.getName(), "right"
        ));
        toppingTableBuilder.append(String.format(" %-10s $%4.2f | %-10s $%4.2f | %-10s $%4.2f |",
                        Size.SMALL.getBreadSize(),
                        topping.getPrice(Size.SMALL),
                        Size.MEDIUM.getBreadSize(),
                        topping.getPrice(Size.MEDIUM),
                        Size.LARGE.getBreadSize(),
                        topping.getPrice(Size.LARGE))
        );
        toppingTableBuilder.append("\n");
    }

    /*-----Helper Methods-----*/
    private int findMaxWidth(ArrayList<Topping> list) {
        int max = 0;
        for (Topping topping : list) {
            if (topping.getName().length() > max) {
                max = topping.getName().length();
            }
        }
        return max;
    }


    @Override
    public void screen() {

    }

    @Override
    public void run() {
        System.out.print(toppingTableBuilder);
    }
}
