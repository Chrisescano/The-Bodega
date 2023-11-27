package org.pluralsight.gui.components;

import org.pluralsight.gui.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class ItemChoiceComponent extends JPanel {
    CustomLabel countLabel;
    int count;

    public ItemChoiceComponent() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(120, 150));

        count = 0;
        countLabel = new CustomLabel(String.valueOf(count), Color.white, Color.black);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        this.add(new CustomLabel("Item", IconUtil.scale("Media/emoji.jpg", 120,120),
                Color.white, Color.black), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.33;
        gbc.weighty = 0;
        CustomButton minusButton = new CustomButton("-", Color.red, Color.white);
        this.add(minusButton, gbc);
        minusButton.addActionListener(e -> {
            if(count == 0) return; //lower limit
            count--;
            countLabel.setText(String.valueOf(count));
        });

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(countLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        CustomButton plusButton = new CustomButton("+", Color.green, Color.white);
        this.add(plusButton, gbc);
        plusButton.addActionListener(e -> {
            if(count == 5) return; //upper limit
            count++;
            countLabel.setText(String.valueOf(count));
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("The Deli Shop");
        frame.setSize(720, 480);

        frame.setLayout(new FlowLayout());
        frame.add(new ItemChoiceComponent());

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Getter-----*/
    public int getCount() {
        return count;
    }
}
