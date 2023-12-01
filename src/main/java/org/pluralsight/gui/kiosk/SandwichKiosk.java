package org.pluralsight.gui.kiosk;

import org.pluralsight.gui.panel.SandwichToppingsPanel;

import javax.swing.*;
import java.awt.*;

public class SandwichKiosk extends JPanel {
    JButton addToCartButton = new JButton("Add To Cart");
    JButton cancelOrderButton = new JButton("Cancel Order");

    public SandwichKiosk() {
        this.setLayout(new BorderLayout());

        this.add(new JScrollPane(new SandwichToppingsPanel()));
        laySouthernButtons();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("The Bodega - Sandwiches");
        frame.setSize(800, 600);

        frame.add(new SandwichKiosk());

        frame.getContentPane().setBackground(Color.black); //testing, turn white for production
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    private void laySouthernButtons() {
        JPanel southernPanelContainer = new JPanel();

        addToCartButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        addToCartButton.setFocusable(false);
        addToCartButton.setBackground(Color.GREEN);
        addToCartButton.setForeground(Color.WHITE);

        cancelOrderButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        cancelOrderButton.setFocusable(false);
        cancelOrderButton.setBackground(Color.RED);
        cancelOrderButton.setForeground(Color.WHITE);

        southernPanelContainer.add(addToCartButton);
        southernPanelContainer.add(cancelOrderButton);
        this.add(southernPanelContainer, BorderLayout.SOUTH);
    }
}
