package org.pluralsight.gui.panel;

import org.pluralsight.gui.util.IconUtil;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JPanel {
    private static final Dimension AppDimensions = new Dimension(800, 600);
    private final JButton newOrderButton = new JButton("New Order");

    public WelcomeScreen(CardLayout mainCardLayout, JPanel mainCardPanel) {
        this.setLayout(new BorderLayout());

        layStoreIconLabel();
        layNewOrderButton();

        newOrderButton.addActionListener(e -> {
            mainCardLayout.show(mainCardPanel, "OrderKiosk");
        });
    }

    /*-----Private Methods-----*/
    private void layStoreIconLabel() {
        JLabel storeIconLabel = new JLabel(
                IconUtil.scale("Media/emoji.jpg", AppDimensions.width, AppDimensions.height)
        );
        this.add(storeIconLabel, BorderLayout.CENTER);
    }

    private void layNewOrderButton() {
        newOrderButton.setFont(new Font("Monospaced", Font.BOLD, 30));
        newOrderButton.setForeground(Color.WHITE);
        newOrderButton.setBackground(Color.GREEN);
        newOrderButton.setFocusable(false);

        //using JPanel default layout to make button smaller
        JPanel buttonContainer = new JPanel();
        buttonContainer.setBackground(Color.WHITE);
        buttonContainer.add(newOrderButton);
        this.add(buttonContainer, BorderLayout.SOUTH);
    }

    /*-----Entry Point-----*/

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("The Bodega - Sandwiches");
        frame.setSize(AppDimensions);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        cardPanel.add(new WelcomeScreen(cardLayout, cardPanel), "WelcomeScreen");
        cardPanel.add(new Orderkiosk(cardLayout, cardPanel), "OrderKiosk");

        frame.add(cardPanel);

        frame.getContentPane().setBackground(Color.black); //testing, turn white for production
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
