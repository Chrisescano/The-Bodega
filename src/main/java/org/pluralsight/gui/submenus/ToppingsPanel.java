package org.pluralsight.gui.submenus;

import javax.swing.*;
import java.awt.*;

public class ToppingsPanel extends JPanel{
    JLabel nameOfSandwichLabel;

    //the issue seems to be ToppingComponents null layout
    //when this class tries to add it then the ToppingComponent has
    //no preferred size so it wont get drawn
    //3 solutions:
    // - make this class null layout (but I worry about this propagating up)
    // - use a layout manager on topping component
    // - override getPreferredSize()
    public ToppingsPanel() {
        styleSandwichNameLabel();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Toppings Component");
        frame.setSize(720, 480);

        frame.add(new ToppingsPanel());

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    private void styleSandwichNameLabel() {
        nameOfSandwichLabel = new JLabel("This Sandwich");
        nameOfSandwichLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        nameOfSandwichLabel.setVerticalAlignment(SwingConstants.TOP);
        nameOfSandwichLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private JPanel buildToppingTypePanel(String toppingType) {
        JLabel toppingTypeLabel = new JLabel(toppingType);
        toppingTypeLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        toppingTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);



        return null;
    }
}
