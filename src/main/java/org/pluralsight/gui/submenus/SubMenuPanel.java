package org.pluralsight.gui.submenus;

import org.pluralsight.gui.components.CustomButton;
import org.pluralsight.gui.components.CustomLabel;
import org.pluralsight.gui.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class SubMenuPanel extends JPanel {
    int numOfOptions;

    public SubMenuPanel(String nameOfSubMenu, int numOfOptions) {
        this.setLayout(new BorderLayout());
        this.numOfOptions = numOfOptions;

        CustomLabel subMenuLabel = new CustomLabel(nameOfSubMenu, Color.white, Color.black);
        subMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(subMenuLabel, BorderLayout.NORTH);
        this.add(buildSubMenuOptions(), BorderLayout.CENTER);
    }

    /*-----Private Methods-----*/
    private JPanel buildSubMenuOptions() {
        JPanel menuOptionsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, 1, 1, 1);

        for(int i = 0; i < numOfOptions; i++) {
            gbc.gridx = i % 3;
            gbc.gridy = i / 3;
            CustomButton sandwichButton = new CustomButton(String.valueOf(i),
                    IconUtil.scale("Media/emoji.jpg", 100, 100),
                    Color.white, Color.black);
            menuOptionsPanel.add(sandwichButton, gbc);

            int sandwichNumber = i;
            sandwichButton.addActionListener(e -> System.out.println("I am sandwich "+ sandwichNumber));
        }

        return menuOptionsPanel;
    }
}
