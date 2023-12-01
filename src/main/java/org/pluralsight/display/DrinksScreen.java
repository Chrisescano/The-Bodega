package org.pluralsight.display;


import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuItems.Drink;
import org.pluralsight.menuItems.ItemManager;
import org.pluralsight.shop.Order;
import org.pluralsight.shop.Size;
import org.pluralsight.util.MenuTable;

public class DrinksScreen implements Displayable {
    Order order;
    MenuTable menuTable;
    ItemManager itemManager;
    Drink drink;

    public DrinksScreen(Order order) {
        this.order = order;
        menuTable = new MenuTable("drinks");
        itemManager = new ItemManager();
    }

    @Override
    public void screen() {
        System.out.println("""
                
                Here Is A Menu Of Our Drinks
                """);
        menuTable.run();
    }

    @Override
    public void run() {
        screen();
        validateDrink();
    }

    private void validateDrink() {
        while (true) {
            String userDrink = ScannerIO.getStringInput("Type In The Name Of The Drink You Would Like: ");
            String[] userDrinkInfo = itemManager.getItemInformation(userDrink);

            if (userDrinkInfo[0] != null && userDrinkInfo[1] != null) {
                drink = new Drink(userDrinkInfo[1]);

                while (true) {
                    String userDrinkSize = ScannerIO.getStringInput("Type In The Size Of Your Drink: ").toUpperCase();
                    switch (userDrinkSize) {
                        case "SMALL", "MEDIUM", "LARGE" -> {
                            drink.setSize(Size.valueOf(userDrinkSize));
                            order.addDrink(drink);
                            return;
                        }
                        default -> System.out.println("Oops, " + userDrinkSize + " Is Not A Valid Size. Type [Small] [Medium] " +
                                "[Large]. Try Again");
                    }
                }
            } else {
                System.out.println("Oops, That Is Not A Valid Drink. Please Try Again");
            }
        }
    }
}
