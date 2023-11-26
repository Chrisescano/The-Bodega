package org.pluralsight.gui.menupanels;

import javax.swing.*;
import java.awt.*;

public class OrderKiosk extends JPanel {
    JButton checkOutButton, cancelOrderButton;
    JButton sandwichPanelButton, drinksPanelButton, chipsPanelButton;


    public OrderKiosk() {
        this.setLayout(new BorderLayout());

        styleCheckOutButton();
        styleCancelOrderButton();

        //sub add
        JPanel orderButtonsPanel = new JPanel();
        orderButtonsPanel.add(cancelOrderButton);
        orderButtonsPanel.add(checkOutButton);

        //add
        this.add(orderButtonsPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Toppings Component");
        frame.setSize(720, 480);

        frame.add(new OrderKiosk());

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    private void styleCheckOutButton() {
        checkOutButton = new JButton("Check Out");
        checkOutButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        checkOutButton.setBackground(Color.white);
        checkOutButton.setForeground(Color.black);
        checkOutButton.setFocusable(false);
    }

    private void styleCancelOrderButton() {
        cancelOrderButton = new JButton("Cancel Order");
        cancelOrderButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        cancelOrderButton.setBackground(Color.red);
        cancelOrderButton.setForeground(Color.white);
        cancelOrderButton.setFocusable(false);
    }
}
