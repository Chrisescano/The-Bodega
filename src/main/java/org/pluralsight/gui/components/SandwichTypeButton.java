package org.pluralsight.gui.components;

import javax.swing.*;
import java.awt.*;

public class SandwichTypeButton extends JPanel {
    JButton sandwichIconButton;

    public SandwichTypeButton() {
        styleSandwichIconLabel();

        sandwichIconButton.addActionListener(e -> System.out.println("Ordering this sandwich"));

        this.add(sandwichIconButton);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Toppings Component");
        frame.setSize(720, 480);

        frame.add(new SandwichTypeButton());

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    private ImageIcon scaleImage(String filePath) {
        ImageIcon imageIcon = new ImageIcon(filePath);
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private void styleSandwichIconLabel() {
        sandwichIconButton = new JButton("Some Sandwich", scaleImage("Media/emoji.jpg"));
        sandwichIconButton.setHorizontalTextPosition(SwingConstants.CENTER);
        sandwichIconButton.setVerticalTextPosition(SwingConstants.TOP);
        sandwichIconButton.setBackground(Color.white);
        sandwichIconButton.setFocusable(false);
    }
}
