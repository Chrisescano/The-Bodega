package org.pluralsight.gui.components;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel{

    public CustomLabel(String text, Color background, Color foreground) {
        this.setText(text);
        this.setFont(new Font("Monospaced", Font.BOLD, 20));
        this.setBackground(background);
        this.setForeground(foreground);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public CustomLabel(ImageIcon icon, Color background) {
        this.setIcon(icon);
        this.setBackground(background);
    }

    public CustomLabel(String text, ImageIcon icon) {
        this.setText(text);
        this.setIcon(icon);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.TOP);
    }
}
