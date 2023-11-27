package org.pluralsight.gui.menupanels;

import org.pluralsight.gui.components.CustomButton;
import org.pluralsight.gui.submenus.SandwichesPanel;
import org.pluralsight.gui.util.IconUtil;
import org.pluralsight.gui.util.PanelManager;

import javax.swing.*;
import java.awt.*;

public class OrderKiosk extends JPanel {
    //JFrame frame;
    CustomButton checkOutButton, cancelOrderButton;
    CustomButton sandwichesButton, drinksButton, chipsButton;


    public OrderKiosk() {
        //this.frame = frame;
        this.setLayout(new BorderLayout());

        /*--Styling--*/
        checkOutButton = new CustomButton("Check Out", Color.white, Color.black);
        cancelOrderButton = new CustomButton("Cancel Order", Color.red, Color.white);
        sandwichesButton = new CustomButton(IconUtil.scale("Media/emoji.jpg", 100, 100), Color.white);
        chipsButton = new CustomButton(IconUtil.scale("Media/emoji.jpg", 100, 100), Color.white);
        drinksButton = new CustomButton(IconUtil.scale("Media/emoji.jpg", 100, 100), Color.white);

        sandwichesButton.setEnabled(false);
        checkOutButton.setEnabled(false);

        /*--Sub Additions--*/
        JPanel orderButtonsPanel = new JPanel();
        orderButtonsPanel.add(cancelOrderButton);
        orderButtonsPanel.add(checkOutButton);

        JPanel subMenuPanel = new JPanel();
        subMenuPanel.setLayout(new GridLayout(3, 1));
        subMenuPanel.add(sandwichesButton);
        subMenuPanel.add(chipsButton);
        subMenuPanel.add(drinksButton);

        /*--Add--*/
        this.add(orderButtonsPanel, BorderLayout.SOUTH);
        this.add(subMenuPanel, BorderLayout.WEST);
        this.add(new SandwichesPanel(), BorderLayout.CENTER);

        implementActionListeners();
    }

    /*-----Private Methods-----*/
    private void implementActionListeners() {
        checkOutButton.addActionListener(e -> {

        });

        cancelOrderButton.addActionListener(e -> {
            PanelManager.swap(PanelManager.getPanel(0));
        });

        sandwichesButton.addActionListener(e -> {
            sandwichesButton.setEnabled(false);
            chipsButton.setEnabled(true);
            drinksButton.setEnabled(true);
        });

        chipsButton.addActionListener(e -> {
            sandwichesButton.setEnabled(true);
            chipsButton.setEnabled(false);
            drinksButton.setEnabled(true);
        });

        drinksButton.addActionListener(e -> {
            sandwichesButton.setEnabled(true);
            chipsButton.setEnabled(true);
            drinksButton.setEnabled(false);
        });
    }
}
