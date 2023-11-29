package org.pluralsight.gui.panel;

import org.pluralsight.gui.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class Orderkiosk extends JPanel {
    private final JButton sandwichMenuButton = new JButton();
    private final JButton drinkMenuButton = new JButton();
    private final JButton chipMenuButton = new JButton();
    private final JButton cancelOrderButton = new JButton();
    private final JButton checkoutButton = new JButton();
    private final JPanel menuButtonsContainer = new JPanel(new GridBagLayout());
    private final GridBagConstraints menuButtonConstraints = new GridBagConstraints();
    private final JPanel southernContainer = new JPanel();

    public Orderkiosk(CardLayout mainCardLayout, JPanel mainCardPanel) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        menuButtonsContainer.setBackground(Color.WHITE);
        southernContainer.setBackground(Color.WHITE);

        //these buttons will stay for the duration of the program life cycle
        menuButtonConstraints.fill = GridBagConstraints.BOTH;
        layMenuButton(sandwichMenuButton, "Sandwiches", 0);
        layMenuButton(drinkMenuButton, "Drinks",1);
        layMenuButton(chipMenuButton, "Chips",2);
        laySouthernButton(cancelOrderButton, "Cancel Order", Color.RED, Color.WHITE);
        laySouthernButton(checkoutButton, "Check Out", Color.GREEN, Color.WHITE);

        this.add(menuButtonsContainer, BorderLayout.WEST);
        this.add(southernContainer, BorderLayout.SOUTH);

        cancelOrderButton.addActionListener(e -> {
            mainCardLayout.show(mainCardPanel, "WelcomeScreen");
        });
    }

    /*-----Private Methods-----*/
    private void layMenuButton(JButton button, String text, int y) {
        //styling button
        button.setText(text);
        button.setIcon(IconUtil.scale("Media/emoji.jpg", 100, 100));
        button.setFont(new Font("Monospaced", Font.BOLD, 20));
        button.setBackground(Color.WHITE);
        button.setVerticalTextPosition(SwingConstants.TOP);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        //setting coordinates
        menuButtonConstraints.gridx = 0;
        menuButtonConstraints.gridy = y;
        menuButtonsContainer.add(button, menuButtonConstraints);
    }

    private void laySouthernButton(JButton button, String text, Color background, Color foreground) {
        button.setText(text);
        button.setFont(new Font("Monospaced", Font.BOLD, 20));
        button.setBackground(background);
        button.setForeground(foreground);
        southernContainer.add(button);
    }
}
