package org.pluralsight.gui.components;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton{

    public CustomButton(String text, Color background, Color foreground) {
        this.setText(text);
        this.setFont(new Font("Monospaced", Font.BOLD, 20));
        this.setBackground(background);
        this.setForeground(foreground);
        setSharedStyling();
    }

    public CustomButton(ImageIcon icon, Color background) {
        this.setIcon(icon);
        this.setBackground(background);
        setSharedStyling();
    }

    public CustomButton(String text, ImageIcon icon, Color background, Color foreground) {
        this.setText(text);
        this.setIcon(icon);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.TOP);
        setSharedStyling();
    }

    /*-----Private Methods-----*/
    private void setSharedStyling() {
        this.setFocusable(false);
        Dimension dimension = this.getPreferredSize();
        this.setPreferredSize(new Dimension(dimension.width + 20, dimension.height + 5));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
    }
}
