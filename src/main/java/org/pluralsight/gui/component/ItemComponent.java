package org.pluralsight.gui.component;

import org.pluralsight.gui.util.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ItemComponent extends JPanel{
    ImageIcon icon;
    JLabel itemLabel;
    JButton selectButton = new JButton("Select");
    GridBagConstraints constraints = new GridBagConstraints();
    ArrayList<JButton> optionButtons = new ArrayList<>();
    boolean[] optionBooleanArray = {false, false, false};

    boolean isSelected;

    public ItemComponent(String filePath, String nameOfItem, boolean enableSelected, String ... options) {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(400, 120));

        icon = IconUtil.scale(filePath, 70, 70);
        itemLabel = new JLabel(nameOfItem, icon, SwingConstants.LEFT);
        this.isSelected = enableSelected;
        optionButtons.add(new JButton("Something"));
        optionButtons.add(new JButton("Something"));
        optionButtons.add(new JButton("Something"));

        /*---Common Things Between ItemComponents---*/
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);
        layItemLabel();
        laySelectButton();
        layOptionButtons(options);

        disableOptions(isSelected);

        /*---Action Listeners---*/
        selectButton.addActionListener(e -> {
            if (!isSelected) {
                selectButton.setBackground(Color.green);
                selectButton.setForeground(Color.white);
                isSelected = true;
            } else {
                selectButton.setBackground(Color.white);
                selectButton.setForeground(Color.black);
                isSelected = false;
            }
            disableOptions(isSelected);
        });
    }

    public void layOptionButtons(String ... options) {
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1.0;
        constraints.gridwidth = 1;
        constraints.gridy = 3;

        for(int i = 0; i < options.length; i++) {
            JButton button = optionButtons.get(i);
            try {
                layOptionButton(options[i], button, i * 2);
            } catch (ArrayIndexOutOfBoundsException e) {
                layOptionButton(null, button, i * 2);
            }

            /*---Action Listener---*/
            button.addActionListener(e -> {
                for (int j = 0; j < optionButtons.size(); j++) {
                    JButton optionButton = optionButtons.get(j);
                    if (e.getSource() == optionButton) {
                        optionButton.setBackground(Color.green);
                        optionButton.setForeground(Color.white);
                        optionBooleanArray[j] = true;
                    } else {
                        optionButton.setBackground(Color.white);
                        optionButton.setForeground(Color.black);
                        optionBooleanArray[j] = false;
                    }
                }
            });
        }
    }

    /*-----Private Methods-----*/
    private void layItemLabel() {
        itemLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 3;
        this.add(itemLabel, constraints);
    }

    private void laySelectButton() {
        selectButton.setFocusable(false);
        selectButton.setFont(new Font("Monospaced", Font.BOLD, 10));
        selectButton.setBackground(Color.white);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        this.add(selectButton, constraints);
    }

    private void layOptionButton(String text, JButton button, int x) {
        if (text != null) button.setText(text);
        button.setFocusable(false);
        button.setFont(new Font("Monospaced", Font.BOLD, 15));
        button.setBackground(Color.white);
        button.setPreferredSize(new Dimension(120, 30)); //keeps buttons same size
        constraints.gridx = x;
        this.add(button, constraints);
    }

    private void disableOptions(boolean flag) {
        for (JButton button : optionButtons) {
            button.setEnabled(flag);
            button.setBackground(Color.white);
            button.setForeground(Color.black);
        }
    }

    /*-----Getters-----*/
    public String getItemName() {
        return itemLabel.getText();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("The Deli Shop");
        frame.setSize(800, 600); //800, 600 is better

        frame.setLayout(new FlowLayout());
        ItemComponent itemComponent = new ItemComponent(
                "Media/emoji.jpg","Wheat", false, "Regular"
        );
        frame.add(itemComponent);

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
