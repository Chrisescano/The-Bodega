package org.pluralsight.gui;


import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        this.setTitle("The Deli Shop");
        this.setSize(420, 420);

        //ImageIcon image = new ImageIcon(/*-name of image-*/);
        //this.setImageIcon(image.getImage());

        this.getContentPane().setBackground(Color.gray);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();

    }
}
