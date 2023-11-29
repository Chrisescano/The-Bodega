package org.pluralsight.gui.panel;

import org.pluralsight.gui.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class Orderkiosk extends JPanel {
    private final JPanel menuButtonsContainer;
    private final GridBagConstraints menuButtonConstraints;
    private final JPanel southernContainer;

    public Orderkiosk(CardLayout mainCardLayout, JPanel mainCardPanel) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        //containers for components
        menuButtonsContainer = new JPanel(new GridBagLayout());
        menuButtonsContainer.setBackground(Color.WHITE);
        southernContainer = new JPanel();
        southernContainer.setBackground(Color.WHITE);

        CardLayout menuCardLayout = new CardLayout();
        JPanel menuCardPanel = new JPanel(menuCardLayout);
        menuCardPanel.add(new JScrollPane(new SanwichMenu()), "SandwichMenu");

        //these buttons will stay for the duration of the program life cycle
        menuButtonConstraints = new GridBagConstraints();
        menuButtonConstraints.fill = GridBagConstraints.BOTH;
        JButton sandwichMenuButton = new JButton();
        layMenuButton(sandwichMenuButton, "Sandwiches", 0);
        JButton drinkMenuButton = new JButton();
        layMenuButton(drinkMenuButton, "Drinks",1);
        JButton chipMenuButton = new JButton();
        layMenuButton(chipMenuButton, "Chips",2);
        JButton cancelOrderButton = new JButton();
        laySouthernButton(cancelOrderButton, "Cancel Order", Color.RED, Color.WHITE);
        JButton checkoutButton = new JButton();
        laySouthernButton(checkoutButton, "Check Out", Color.GREEN, Color.WHITE);

        //adding everything
        this.add(menuButtonsContainer, BorderLayout.WEST);
        this.add(southernContainer, BorderLayout.SOUTH);
        this.add(menuCardPanel, BorderLayout.CENTER);

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
