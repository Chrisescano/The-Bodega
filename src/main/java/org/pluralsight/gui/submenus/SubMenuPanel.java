package org.pluralsight.gui.submenus;

import org.pluralsight.gui.components.CustomLabel;
import org.pluralsight.gui.components.SandwichTypeButton;

import javax.swing.*;
import java.awt.*;

public class SubMenuPanel extends JPanel {
    CustomLabel subMenuLabel;
    int numOfOptions;

    public SubMenuPanel(String nameOfSubMenu, int numOfOptions) {
        this.numOfOptions = numOfOptions;

        subMenuLabel = new CustomLabel(nameOfSubMenu, Color.white, Color.black);
        JPanel subMenuOptions = buildSubMenuOptions();

        this.add(subMenuLabel);
        this.add(subMenuOptions);
    }

    /*-----Private Method----*/
    private JPanel buildSubMenuOptions() {
        JPanel subMenuOptionsContainer = new JPanel();

        for (int i = 0; i < numOfOptions; i++) {
            subMenuOptionsContainer.add(new SandwichTypeButton());
        }

        return subMenuOptionsContainer;
    }
}
