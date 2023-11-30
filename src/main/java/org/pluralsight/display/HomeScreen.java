package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;

public class HomeScreen implements Displayable {
    @Override
    public void screen() {
        System.out.print("""
                Welcome To The Bodega Sandwich Shop!
                Would You Like To:
                  (1) - Make A New Order
                  (0) - Quit The Program
                """);
    }

    @Override
    public void run() {
        while (true) {
            screen();
            int userInput = ScannerIO.getIntInput("Enter Your Command: ");
            switch (userInput) {
                case 1 -> new OrderScreen().run();
                case 0 -> { return; }
                default -> System.out.println("Sorry, "+ userInput +" Is Not A Valid Command. Try Again");
            }
        }
    }
}