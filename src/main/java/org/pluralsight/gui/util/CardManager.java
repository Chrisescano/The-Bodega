package org.pluralsight.gui.util;

import javax.swing.*;
import java.awt.*;

public class CardManager {

    public static CardLayout mainCardLayout = new CardLayout();
    public static CardLayout orderCardLayout = new CardLayout();
    public static JPanel mainCardPanel = new JPanel(mainCardLayout);
    public static JPanel orderCardPanel = new JPanel(orderCardLayout);

    public static void addToMainCardPanel(JPanel panel, String panelName) {
        mainCardPanel.add(panel, panelName);
    }

    public static void addToOrderCardPanel(JPanel panel, String panelName) {
        mainCardPanel.add(panel, panelName);
    }

    public static void showNextMainCard() {
        mainCardLayout.next(mainCardPanel);
    }

    public static void showNextOrderPanel() {
        orderCardLayout.next(orderCardPanel);
    }
}
