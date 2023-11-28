package org.pluralsight.display;

public class SandwichScreen implements Displayable{
    //sandwich object

    SandwichScreen() {
        //initialize sandwich object
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
            //code here for a new sandwich object
            sandwichBreadPrompt();
            sandwichSizePrompt();
            sandwichMeatPrompt();
            sandwichCheesePrompt();
            sandwichRegularPrompt();
            sandwichSaucePrompt();
            sandwichSidePrompt();
            sandwichToastPrompt();

            break; //temporary, remove when done
        }
    }

    private void sandwichBreadPrompt() {
        //ask user what kind of bread
        //show user bread options
        //user selects bread
        //add bread type to sandwich

        //this template can be followed for almost all methods in sandwich screen
    }

    private void sandwichSizePrompt() {

    }

    private void sandwichMeatPrompt() {

    }

    private void sandwichCheesePrompt() {

    }

    private void sandwichRegularPrompt() {

    }

    private void sandwichSaucePrompt() {

    }

    private void sandwichSidePrompt() {

    }

    private void sandwichToastPrompt() {

    }
}
