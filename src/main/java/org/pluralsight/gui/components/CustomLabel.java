package org.pluralsight.gui.components;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel{

    public CustomLabel(String text) {
        this.setText(text);
        this.setFont(new Font("Monospaced", Font.BOLD, 20));
    }

    public CustomLabel(ImageIcon icon) {
        this.setIcon(icon);
    }

    public CustomLabel(String text, ImageIcon icon) {
        this.setText(text);
        this.setIcon(icon);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.TOP);
    }
}
