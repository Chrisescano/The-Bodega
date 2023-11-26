package org.pluralsight.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Todo:
 * - get a better image
 * - do some fancy animations
 * - since animations I don't think jlayeredpane will do great but we can try
 */
public class WelcomeScreen extends JLayeredPane {
    JLabel welcomeLabel;
    JButton newOrderButton;
    int width, height;

    public WelcomeScreen(int width, int height) {
        this.width = width;
        this.height = height;

        styleWelcomeLabel();
        styleNewOrderButton();

        newOrderButton.addActionListener(e -> System.out.println("I am alive!"));

        this.add(welcomeLabel, Integer.valueOf(0));
        this.add(newOrderButton, Integer.valueOf(1));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Toppings Component");
        frame.setSize(720, 480);

        frame.add(new WelcomeScreen(720, 480));

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    //to properly scale image might have to take int size and width from JFrame
    private ImageIcon scaleImage(String filePath) {
        ImageIcon imageIcon = new ImageIcon(filePath);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private void styleWelcomeLabel() {
        welcomeLabel = new JLabel();
        welcomeLabel.setIcon(scaleImage("Media/emoji.jpg"));
        welcomeLabel.setBounds(0, 0, width, height); //needed for null layout
    }

    private void styleNewOrderButton() {
        newOrderButton = new JButton("New Order");
        newOrderButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        newOrderButton.setBackground(Color.green);
        newOrderButton.setForeground(Color.white);
        newOrderButton.setFocusable(false);
        newOrderButton.setBounds((width - 150) / 2, height - 70, 150, 30); //needed for null layout
    }
}
