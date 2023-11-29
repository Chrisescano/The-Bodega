package org.pluralsight.gui.panel;

import org.pluralsight.gui.util.IconUtil;

import javax.swing.*;
import java.awt.*;
/**
 * Parts Of The Logic Needed:
 * - different types of sandwiches
 */
public class SanwichMenu extends JPanel {
    GridBagConstraints constraints;
    public SanwichMenu() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(1, 1, 1, 1);

        laySandwichMenuLabel();
        laySandwichButtons();
    }

    /*-----Private Methods-----*/
    private void laySandwichMenuLabel() {
        JPanel labelContainer = new JPanel();
        labelContainer.setBackground(Color.WHITE);

        JLabel sandwichMenuLabel = new JLabel("Check Out These Bodega Approved Delights");
        sandwichMenuLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        sandwichMenuLabel.setBackground(Color.WHITE);
        sandwichMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sandwichMenuLabel.setVerticalTextPosition(SwingConstants.CENTER);
        labelContainer.add(sandwichMenuLabel);
        this.add(labelContainer, BorderLayout.NORTH);
    }

    private void laySandwichButtons() {
        JPanel sandwichButtonsContainer = new JPanel(new GridBagLayout());
        sandwichButtonsContainer.setBackground(Color.WHITE);

        //hard coded 1, change this for logic
        int numberOfSandwiches = 7;
        for (int i = 0; i < numberOfSandwiches; i++) {
            JButton sandwichButton = new JButton(
                    "Build Your Own", IconUtil.scale("Media/emoji.jpg", 120, 120)
            );
            sandwichButton.setBackground(Color.WHITE);
            sandwichButton.setHorizontalTextPosition(SwingConstants.CENTER);
            sandwichButton.setVerticalTextPosition(SwingConstants.TOP);
            sandwichButton.setFocusable(false);
            constraints.gridx = i % 4;
            constraints.gridy = i / 4;
            sandwichButtonsContainer.add(sandwichButton, constraints);
        }
        this.add(sandwichButtonsContainer, BorderLayout.CENTER);
    }
}
