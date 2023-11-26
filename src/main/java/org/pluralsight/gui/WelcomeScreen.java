package org.pluralsight.gui;

import org.pluralsight.gui.components.CustomButton;
import org.pluralsight.gui.components.CustomLabel;
import org.pluralsight.gui.util.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Todo:
 * - get a better image
 * - do some fancy animations
 * - since animations I don't think jlayeredpane will do great but we can try
 */
public class WelcomeScreen extends JPanel implements ActionListener {
    CustomLabel storeLogoLabel;
    CustomButton newOrderButton;
    int width, height;

    public WelcomeScreen(int width, int height) {
        this.width = width;
        this.height = height;
        this.setLayout(new BorderLayout());

        storeLogoLabel = new CustomLabel(IconUtil.scale("Media/emoji.jpg", 720, 480));

        newOrderButton = new CustomButton("New Order");
        newOrderButton.setForeground(Color.white);
        newOrderButton.setBackground(Color.green);

        JPanel buttonContainer = new JPanel();
        buttonContainer.add(newOrderButton);

        this.add(storeLogoLabel, BorderLayout.CENTER);
        this.add(buttonContainer, BorderLayout.SOUTH);

        newOrderButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newOrderButton) {
            System.out.println("Printing");
        }
    }
}
