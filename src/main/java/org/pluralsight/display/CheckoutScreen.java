package org.pluralsight.display;

import org.pluralsight.io.ScannerIO;
import org.pluralsight.shop.Order;
import org.pluralsight.shop.Receipt;

public class CheckoutScreen implements Displayable{
    private final Order order;

    public CheckoutScreen(Order order) {
        this.order = order;
    }

    @Override
    public void screen() {
        System.out.println("""
                
                So Far Here Is How Your Order Looks Like:
                """);
        order.printOrder();
    }

    @Override
    public void run() {
        screen();

        boolean saveOrder = ScannerIO.getBooleanInput(
                "Type In Confirm If Everything Looks Ok OR Cancel To Go Back To The Home Screen: ");
        if (saveOrder) order.save();
    }
}
