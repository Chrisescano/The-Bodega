package org.pluralsight.gui.submenus;

import org.pluralsight.gui.components.CustomLabel;
import org.pluralsight.gui.components.ItemChoiceComponent;

import javax.swing.*;
import java.awt.*;

public class MenuItemPanel extends JPanel{

    public MenuItemPanel() {
        this.setLayout(new BorderLayout());

        CustomLabel itemTypeLabel = new CustomLabel("Name Of Item", Color.white, Color.black);


        this.add(itemTypeLabel, BorderLayout.NORTH);
        this.add(buildItemSubChoicesPanel(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("The Deli Shop");
        frame.setSize(720, 480);

        frame.add(new MenuItemPanel());

        frame.getContentPane().setBackground(Color.gray);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    private JPanel buildItemChoicesPanel() {
        JPanel itemChoicesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        int numberOfChoices = 5;
        for(int i = 0; i < numberOfChoices; i++) {
            gbc.gridx = i % 4;
            gbc.gridy = i / 4;

            itemChoicesPanel.add(new ItemChoiceComponent(), gbc);
        }
        return itemChoicesPanel;
    }

    private JPanel buildItemSubChoicesPanel() {
        JPanel itemSubChoicesPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        int numberOfSubChoices = 2;
        for(int i = 0; i < numberOfSubChoices; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;

            JPanel itemChoicesPanel = new JPanel(new GridBagLayout());
            GridBagConstraints choicesConstraints = new GridBagConstraints();

            choicesConstraints.gridx = 0;
            choicesConstraints.gridy = 0;
            itemChoicesPanel.add(new CustomLabel("Sub Choice", Color.white, Color.black), choicesConstraints);

            choicesConstraints.gridy = 1;
            itemChoicesPanel.add(buildItemChoicesPanel(), choicesConstraints);
            itemSubChoicesPanel.add(itemChoicesPanel, gbc);
        }

        return itemSubChoicesPanel;
    }
}
