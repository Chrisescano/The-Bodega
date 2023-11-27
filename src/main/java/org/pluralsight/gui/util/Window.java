package org.pluralsight.gui.util;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        this.setTitle("The Deli Shop");
        this.setSize(720, 480); //800, 600 is better

        this.getContentPane().setBackground(Color.gray);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
