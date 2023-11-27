package org.pluralsight.gui.submenus;

import org.pluralsight.gui.components.SandwichTypeButton;

import javax.swing.*;
import java.awt.*;


public class SandwichesPanel extends JPanel {
    JLabel sandwichLabel;

    public SandwichesPanel() {
        this.setLayout(new GridLayout(2, 1, 0, -350));

        styleSignatureSandwichLabel();

        //sub add
        /*
        Note:
        - the last sandwich option will be the build your own
        - figure out some way of scrolling since sandwiches will get cropped
         */
        JPanel sandwichesContainer = new JPanel();
        sandwichesContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        sandwichesContainer.add(new SandwichTypeButton());
        sandwichesContainer.add(new SandwichTypeButton());
        sandwichesContainer.add(new SandwichTypeButton());
        sandwichesContainer.add(new SandwichTypeButton());
        sandwichesContainer.add(new SandwichTypeButton());
        sandwichesContainer.add(new SandwichTypeButton());
        sandwichesContainer.add(new SandwichTypeButton());
        sandwichesContainer.add(new SandwichTypeButton());
        sandwichesContainer.add(new SandwichTypeButton());


        //add
        this.add(sandwichLabel);
        this.add(sandwichesContainer);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Toppings Component");
        frame.setSize(720, 480);

        frame.add(new SandwichesPanel());

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    private void styleSignatureSandwichLabel() {
        sandwichLabel = new JLabel("Sandwiches");
        sandwichLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        sandwichLabel.setVerticalAlignment(SwingConstants.TOP);
        sandwichLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
