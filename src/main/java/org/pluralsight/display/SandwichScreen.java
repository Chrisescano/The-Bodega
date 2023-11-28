package org.pluralsight.display;

import org.pluralsight.menuitems.Item;
import org.pluralsight.shop.Sandwich;
import org.pluralsight.shop.Size;

import java.util.ArrayList;

public class SandwichScreen implements Displayable{
    Sandwich sandwich;

    SandwichScreen() {
        sandwich = new Sandwich();
    }

    @Override
    public void display() {
        System.out.print("""
                Let's Guide You Through The Sandwich Making Process
                
                """);
    }

    @Override
    public void run() {
        display();
        while (true) {
            sandwichItemPrompt("Here Are The Different Breads We Have:", sandwich.getBreadToppings());
            sandwichSizePrompt();
            sandwichItemPrompt("Here Are The Different Meats We Have:", sandwich.getMeatToppings());
            sandwichItemPrompt("Here Are The Different Cheeses We Have:", sandwich.getCheeseToppings());
            sandwichItemPrompt("Here Are The Different Regular Toppings We Have:", sandwich.getRegularToppings());
            sandwichItemPrompt("Here Are The Different Sauces We Have:", sandwich.getSauceToppings());
            sandwichItemPrompt("Here Are The Different Sides We Have:", sandwich.getSideToppings());
            break;
        }
    }

    /*-----Private Methods-----*/

    private void sandwichItemPrompt(String prompt, ArrayList<Item> items) {
        System.out.println(prompt);
        for (Item item : items) item.toTerminal();
    }

    private void sandwichSizePrompt() {
        System.out.println("Here Are The Different Bread Sizes We Have: ");
        for (Size size : Size.values()) System.out.println(size);
    }

    private void sandwichToastPrompt() {
        //boolean userInput = ScannerIO.getBooleanInput("Would You Like Your Sandwich Toasted? (yes or no)");
        //add toasting sandwich boolean to sandwich
    }

    /*-----Getters-----*/
    public Sandwich getSandwich() {
        return sandwich;
    }

}
