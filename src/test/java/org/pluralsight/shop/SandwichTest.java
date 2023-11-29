package org.pluralsight.shop;

import org.junit.jupiter.api.Test;
import org.pluralsight.menuitems.Item;
import org.pluralsight.menuitems.ItemManager;
import org.pluralsight.menuitems.RegularItem;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void addMeat() {
        Sandwich s = new Sandwich();
        String meat = "Steak";
        assertEquals(0, s.addMeat(meat));
    }

    @Test
    void addCheese() {
        Sandwich s = new Sandwich();
        String cheese = "American";
        assertEquals(0, s.addCheese(cheese));
    }

    @Test
    void addRegularTopping() {
        Sandwich s = new Sandwich();
        String regTopping = "lettuce";
        assertEquals(0, s.addRegularTopping(regTopping));
    }

    @Test
    void addSauce() {
        Sandwich s = new Sandwich();
        String sauce = "mayo";
        assertEquals(0, s.addSauce(sauce));
    }

    @Test
    void addSide() {
        Sandwich s = new Sandwich();
        String side = "au jus";
        assertEquals(0, s.addSide(side));
    }

    @Test
    void remove() {

    }

    @Test
    void getBreadToppings() {
        Sandwich s = new Sandwich();
        ItemManager btIM = new ItemManager("breads.csv", false);

        assertEquals(btIM.getItemList().get(0).getItemName(), s.getBreadToppings().get(0).getItemName());
    }

    @Test
    void getMeatToppings() {
        Sandwich s = new Sandwich();
        ItemManager meatIM = new ItemManager("meats.csv", true);
        assertEquals(meatIM.getItemList().get(0).getItemName(), s.getMeatToppings().get(0).getItemName());
    }

    @Test
    void getCheeseToppings() {
        Sandwich s = new Sandwich();
        ItemManager cheeseIM = new ItemManager("cheeses.csv", true);
        assertEquals(cheeseIM.getItemList().get(0).getItemName(), s.getCheeseToppings().get(0).getItemName());
    }

    @Test
    void getRegularToppings() {
        Sandwich s = new Sandwich();
        ItemManager regularIM = new ItemManager("regular.csv", false);
        assertEquals(regularIM.getItemList().get(0).getItemName(), s.getRegularToppings().get(0).getItemName());
    }

    @Test
    void getSauceToppings() {
        Sandwich s = new Sandwich();
        ItemManager sauceIM = new ItemManager("sauces.csv", false);
        assertEquals(sauceIM.getItemList().get(0).getItemName(), s.getSauceToppings().get(0).getItemName());
    }

    @Test
    void getSideToppings() {
        Sandwich s = new Sandwich();
        ItemManager sideIM = new ItemManager("sides.csv", false);
        assertEquals(sideIM.getItemList().get(0).getItemName(), s.getSideToppings().get(0).getItemName());
    }
}