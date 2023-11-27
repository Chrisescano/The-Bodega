package org.pluralsight.gui.menupanels;

import org.pluralsight.gui.components.CustomButton;
import org.pluralsight.gui.components.CustomLabel;
import org.pluralsight.gui.util.IconUtil;
import org.pluralsight.gui.util.PanelManager;

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
    //JFrame frame;
    CustomLabel storeLogoLabel;
    CustomButton newOrderButton;

    public WelcomeScreen() {
        //this.frame = frame;
        this.setLayout(new BorderLayout());

        //styling
        storeLogoLabel = new CustomLabel(IconUtil.scale("Media/emoji.jpg", 720, 480), Color.white);
        newOrderButton = new CustomButton("New Order", Color.green, Color.white);

        //sub adding
        JPanel buttonContainer = new JPanel();
        buttonContainer.add(newOrderButton);

        //adding
        this.add(storeLogoLabel, BorderLayout.CENTER);
        this.add(buttonContainer, BorderLayout.SOUTH);

        newOrderButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newOrderButton) {
            //logic code goes here for starting a new order

            PanelManager.swap(PanelManager.getPanel(1));
        }
    }
}
