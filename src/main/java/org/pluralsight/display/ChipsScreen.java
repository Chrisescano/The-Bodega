package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuItems.Chip;
import org.pluralsight.menuItems.ItemManager;
import org.pluralsight.shop.Order;
import org.pluralsight.util.MenuTable;

public class ChipsScreen implements Displayable {
    Order order;
    MenuTable menuTable;
    ItemManager itemManager;
    Chip chip;

    public ChipsScreen(Order order) {
        this.order = order;
        menuTable = new MenuTable("chips");
        itemManager = new ItemManager();
    }

    @Override
    public void screen() {
        System.out.println("""
                
                Here Is A Menu Of Our Chips
                """);
        menuTable.run();
    }

    @Override
    public void run() {
        screen();
        validateChip();
    }

    public void validateChip() {
        while (true) {
            String userChip = ScannerIO.getStringInput("Type In The Name Of The Chip You Would Like: ");
            String[] userChipInfo = itemManager.getItemInformation(userChip);

            if (userChipInfo[0] != null && userChipInfo[1] != null) {
                chip = new Chip(userChipInfo[1]);
                order.addChip(chip);
                return;
            } else {
                System.out.println("Oops, That Is Not A Valid Chip. Please Try Again");
            }

        }
    }
}
