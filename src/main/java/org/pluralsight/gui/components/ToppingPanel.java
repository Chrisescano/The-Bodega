package org.pluralsight.gui.components;

import javax.swing.*;
import java.awt.*;

public class ToppingPanel extends JPanel {
    Rectangle panelDimensions;

    JButton plusButton, minusButton;
    JLabel toppingLabel, countLabel;
    ImageIcon image;
    int count;

    /*
    might be good to make the parameter of the constructor to be a topping
     */
    public ToppingPanel(String filePath, int count) {
        image = scaleImage(filePath);
        this.count = count;

        panelDimensions = new Rectangle(150, 175);
        this.setSize(panelDimensions.getSize());
        this.setLayout(null);

        //styling components
        styleToppingLabel();
        styleCountLabel();
        styleMinusButton();
        stylePlusButton();

        plusButton.addActionListener(e -> incrementCount());
        minusButton.addActionListener(e -> decrementCount());

        //add
        this.add(toppingLabel);
        this.add(countLabel);
        this.add(minusButton);
        this.add(plusButton);
    }

    //testing
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Toppings Component");
        frame.setSize(400, 400);

        ToppingPanel topping = new ToppingPanel("Media/emoji.jpg", 0);
        frame.add(topping);

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    private ImageIcon scaleImage(String filePath) {
        ImageIcon imageIcon = new ImageIcon(filePath);
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private void styleToppingLabel() {
        toppingLabel = new JLabel("Topping");
        toppingLabel.setIcon(image);
        toppingLabel.setBounds(panelDimensions.x, panelDimensions.y, panelDimensions.width, panelDimensions.height - 25);
        toppingLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        toppingLabel.setVerticalTextPosition(SwingConstants.TOP);
        toppingLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        toppingLabel.setIconTextGap(-20);
    }

    private void styleCountLabel() {
        countLabel = new JLabel(String.valueOf(count));
        countLabel.setBounds(panelDimensions.x + 50, panelDimensions.y + 150, 50, 25);
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countLabel.setFont(new Font("Monospaced", Font.BOLD, countLabel.getHeight() - 3));
    }

    private void stylePlusButton() {
        plusButton = new JButton("+");
        plusButton.setBounds(panelDimensions.x + 100, panelDimensions.y + 150, 50, 25);
        plusButton.setFont(new Font("Monospaced", Font.BOLD, plusButton.getHeight() - 3));
        plusButton.setBackground(Color.green);
        plusButton.setForeground(Color.white);
        plusButton.setFocusable(false);
    }

    private void styleMinusButton() {
        minusButton = new JButton("-");
        minusButton.setBounds(panelDimensions.x, panelDimensions.y + 150, 50, 25);
        minusButton.setFont(new Font("Monospaced", Font.BOLD, minusButton.getHeight() - 3));
        minusButton.setBackground(Color.red);
        minusButton.setForeground(Color.white);
        minusButton.setFocusable(false);
    }

    private void incrementCount() {
        count++;
        countLabel.setText(String.valueOf(count));
    }

    private void decrementCount() {
        if(count == 0) return;
        count--;
        countLabel.setText(String.valueOf(count));
    }

    /*-----Getter-----*/
    public int getCount() {
        return count;
    }
}
