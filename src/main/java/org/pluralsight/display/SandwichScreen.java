package org.pluralsight.display;

import org.pluralsight.shop.Order;

public class SandwichScreen implements Displayable{
    Order order;

    SandwichScreen(Order order) {
        this.order = order;
    }

    @Override
    public void screen() {
        System.out.print("""
                
                Here Is A List Of All Our Sandwiches
                """);
    }

    @Override
    public void run() {
        
    }
}
