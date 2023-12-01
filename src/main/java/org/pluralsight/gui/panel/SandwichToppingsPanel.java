package org.pluralsight.gui.panel;

import org.pluralsight.gui.component.ItemComponent;

import javax.swing.*;
import java.awt.*;

public class SandwichToppingsPanel extends JPanel {
    private final GridBagConstraints panelConstraints;
    private int panelY = 0;

    public SandwichToppingsPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        panelConstraints = new GridBagConstraints();
        panelConstraints.fill = GridBagConstraints.BOTH;
        panelConstraints.gridx = 0;
        panelConstraints.gridy = panelY;
        JLabel sandwichNameLabel = new JLabel("Build Your Own");
        sandwichNameLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
        sandwichNameLabel.setBackground(Color.WHITE);
        sandwichNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sandwichNameLabel.setVerticalAlignment(SwingConstants.CENTER);

        this.add(sandwichNameLabel, panelConstraints);
        laySandwichSection("Meats", "Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
        laySandwichSection("Cheeses", "American", "Provolone", "Swiss");
    }

    /*-----Private Methods-----*/
    private void laySandwichSection(String sectionName, String ... items) {
        JPanel sandwichSectionPanel = new JPanel(new GridBagLayout());
        sandwichSectionPanel.setBackground(Color.WHITE);
        sandwichSectionPanel.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));

        GridBagConstraints sectionConstraints = new GridBagConstraints();
        sectionConstraints.fill = GridBagConstraints.BOTH;
        sectionConstraints.insets = new Insets(5, 5, 5, 5);
        sectionConstraints.gridx = 0;
        sectionConstraints.gridy = 0;
        JLabel sectionLabel = new JLabel(sectionName);
        sectionLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
        sandwichSectionPanel.add(sectionLabel, sectionConstraints);

        for(int i = 0; i < items.length; i++) {
            sectionConstraints.gridx = i % 2;
            sectionConstraints.gridy = (i / 2) + 1;
            sandwichSectionPanel.add(new ItemComponent(
                    "Media/emoji.jpg", items[i], false, "Regular", "Extra"
            ), sectionConstraints);
        }

        panelY++;
        panelConstraints.gridy = panelY;
        this.add(sandwichSectionPanel, panelConstraints);
    }
}