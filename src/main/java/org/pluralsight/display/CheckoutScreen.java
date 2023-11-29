package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.shop.Order;
import org.pluralsight.shop.Receipt;

public class CheckoutScreen implements Displayable{
    private Order order;

    public CheckoutScreen(Order order) {
        this.order = order;
    }

    @Override
    public void display() {
        System.out.println("""
                
                So Far Here Is How Your Order Looks Like:
                """);
    }

    @Override
    public void run() {
        display();
        order.printOrder();

        while (true) {
            boolean userBool = ScannerIO.getBooleanInput("Type In Confirm To Save Your Order Or Cancel To Discard: ");
            if (userBool) {
                order.saveOrder();
            }
            return;
        }
    }
}
