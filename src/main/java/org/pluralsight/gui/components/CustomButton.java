package org.pluralsight.gui.components;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton{

    public CustomButton(String text) {
        this.setText(text);
        this.setFont(new Font("Monospaced", Font.BOLD, 20));
        setSharedStyling();
    }

    public CustomButton(ImageIcon icon) {
        this.setIcon(icon);
        setSharedStyling();
    }

    public CustomButton(String text, ImageIcon icon) {
        this.setText(text);
        this.setIcon(icon);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.TOP);
        setSharedStyling();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Toppings Component");
        frame.setSize(720, 480);

        JPanel container = new JPanel();
        container.add(new CustomButton("Something"));

        frame.add(container);

        frame.getContentPane().setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /*-----Private Methods-----*/
    private void setSharedStyling() {
        this.setFocusable(false);
        Dimension dimension = this.getPreferredSize();
        this.setPreferredSize(new Dimension(dimension.width + 20, dimension.height + 5));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
    }
}
