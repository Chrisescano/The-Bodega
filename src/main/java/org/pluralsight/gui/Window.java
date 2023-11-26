package org.pluralsight.gui;


import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    WelcomeScreen welcomeScreen;

    public Window() {
        this.setTitle("The Deli Shop");
        this.setSize(720, 480);

        welcomeScreen = new WelcomeScreen(this.getWidth(), this.getHeight());
        this.add(welcomeScreen);

        this.getContentPane().setBackground(Color.gray);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
