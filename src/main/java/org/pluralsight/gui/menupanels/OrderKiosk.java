package org.pluralsight.gui.menupanels;

import javax.swing.*;
import java.awt.*;

public class OrderKiosk extends JPanel {
    JButton checkOutButton, cancelOrderButton;
    JButton sandwichesPanelButton, drinksPanelButton, chipsPanelButton;


    public OrderKiosk() {
        this.setLayout(new BorderLayout());

        /*--Styling--*/
        styleCheckOutButton();
        styleCancelOrderButton();
        styleSandwichesPanelButton();
        styleChipsPanelButton();
        styleDrinksPanelButton();

        /*--Action Listeners--*/
        checkOutButton.addActionListener(e -> System.out.println("Check out"));
        cancelOrderButton.addActionListener(e -> System.out.println("Cancel Order"));

        /*--Sub Additions--*/
        JPanel orderButtonsPanel = new JPanel();
        orderButtonsPanel.add(cancelOrderButton);
        orderButtonsPanel.add(checkOutButton);

        JPanel partsOfOrderPanel = new JPanel();
        partsOfOrderPanel.setLayout(new GridLayout(3, 1));
        partsOfOrderPanel.add(sandwichesPanelButton);
        partsOfOrderPanel.add(chipsPanelButton);
        partsOfOrderPanel.add(drinksPanelButton);

        /*--Add--*/
        this.add(orderButtonsPanel, BorderLayout.SOUTH);
        this.add(partsOfOrderPanel, BorderLayout.WEST);
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
    private ImageIcon scaleImage(String filePath) {
        ImageIcon imageIcon = new ImageIcon(filePath);
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

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

    private void styleSandwichesPanelButton() {
        sandwichesPanelButton = new JButton(scaleImage("Media/emoji.jpg"));
        sandwichesPanelButton.setBackground(Color.white);
        sandwichesPanelButton.setFocusable(false);
    }

    private void styleChipsPanelButton() {
        chipsPanelButton = new JButton(scaleImage("Media/emoji.jpg"));
        chipsPanelButton.setBackground(Color.white);
        chipsPanelButton.setFocusable(false);
    }

    private void styleDrinksPanelButton() {
        drinksPanelButton = new JButton(scaleImage("Media/emoji.jpg"));
        drinksPanelButton.setBackground(Color.white);
        drinksPanelButton.setFocusable(false);
    }
}
