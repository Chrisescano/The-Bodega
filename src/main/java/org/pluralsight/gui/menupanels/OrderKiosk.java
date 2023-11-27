package org.pluralsight.gui.menupanels;

import org.pluralsight.gui.components.CustomButton;
import org.pluralsight.gui.submenus.SubMenuPanel;
import org.pluralsight.gui.util.IconUtil;
import org.pluralsight.gui.util.PanelManager;

import javax.swing.*;
import java.awt.*;

public class OrderKiosk extends JPanel {
    CustomButton checkOutButton, cancelOrderButton;
    CustomButton sandwichesButton, drinksButton, chipsButton;
    CardLayout cardLayout;
    JPanel cardPanel;

/*
Todo:
- change isEnabled icon image for sub menus
 */
    public OrderKiosk() {
        this.setLayout(new BorderLayout());

        /*--Card Layout For Easy Switching--*/
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(new JScrollPane(new SubMenuPanel("Sandwiches", 20)), "sandwiches");
        cardPanel.add(new JScrollPane(new SubMenuPanel("Chips", 2)), "chips");
        cardPanel.add(new JScrollPane(new SubMenuPanel("Drinks", 1)), "drinks");

        /*--Styling--*/
        checkOutButton = new CustomButton("Check Out", Color.white, Color.black);
        cancelOrderButton = new CustomButton("Cancel Order", Color.red, Color.white);
        sandwichesButton = new CustomButton(IconUtil.scale("Media/emoji.jpg", 100, 100), Color.white);
        chipsButton = new CustomButton(IconUtil.scale("Media/emoji.jpg", 100, 100), Color.white);
        drinksButton = new CustomButton(IconUtil.scale("Media/emoji.jpg", 100, 100), Color.white);

        checkOutButton.setEnabled(false);

        /*--Sub Additions--*/
        JPanel orderButtonsPanel = new JPanel();
        orderButtonsPanel.add(cancelOrderButton);
        orderButtonsPanel.add(checkOutButton);

        JPanel menuButtonContainer = new JPanel();
        menuButtonContainer.setLayout(new GridLayout(3, 1));
        menuButtonContainer.add(sandwichesButton);
        menuButtonContainer.add(chipsButton);
        menuButtonContainer.add(drinksButton);

        /*--Add--*/
        this.add(orderButtonsPanel, BorderLayout.SOUTH);
        this.add(menuButtonContainer, BorderLayout.WEST);
        this.add(cardPanel, BorderLayout.CENTER);

        implementActionListeners();
    }

    /*-----Private Methods-----*/
    private void implementActionListeners() {
        checkOutButton.addActionListener(e -> {

        });

        cancelOrderButton.addActionListener(e -> PanelManager.swap(PanelManager.getPanel(0)));

        sandwichesButton.addActionListener(e -> {
            sandwichesButton.setEnabled(false);
            chipsButton.setEnabled(true);
            drinksButton.setEnabled(true);

            cardLayout.show(cardPanel, "sandwiches");
        });

        chipsButton.addActionListener(e -> {
            sandwichesButton.setEnabled(true);
            chipsButton.setEnabled(false);
            drinksButton.setEnabled(true);

            cardLayout.show(cardPanel, "chips");
        });

        drinksButton.addActionListener(e -> {
            sandwichesButton.setEnabled(true);
            chipsButton.setEnabled(true);
            drinksButton.setEnabled(false);

            cardLayout.show(cardPanel, "drinks");
        });
    }
}
