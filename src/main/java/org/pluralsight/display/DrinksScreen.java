package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.menuitems.Item;
import org.pluralsight.shop.Drink;
import org.pluralsight.shop.Order;
import org.pluralsight.shop.Size;


import java.util.ArrayList;


public class DrinksScreen implements Displayable {
    Drink drink;
    Order order;
    public DrinksScreen(Order order) {
        drink = new Drink();
        this.order = order;
    }


    @Override
    public void display() {
        System.out.println("Drinks Menu");

    }

    @Override
    public void run() {
        display();

        chooseDrink("\nDrinks Available:  ", "drink", drink.getDrinks());
//        order.addDrink(drink);

    }
    private  void chooseDrink(String message, String type, ArrayList<Item>list){
        int flag = -1;
        while (flag == -1) {
            System.out.println("\n" + message);
            for (Item item : list) item.toTerminal();
            String userChoice = ScannerIO.getStringInput("Type In The " + type + " You Would Like: ");
           flag = drink.addDrink(userChoice,list);

            if (flag == -1)
                System.out.println("Oops, We Do Not Have " + userChoice + " As A " + type + ". Please Try Again");
        }
    }

    private void drinkList(String prompt, ArrayList<Item> items) {
        System.out.println("\n" + prompt);
        for (Item item : items) item.toTerminal();
    }


}
