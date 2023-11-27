package org.pluralsight.gui.util;

import org.pluralsight.gui.menupanels.WelcomeScreen;
import org.pluralsight.gui.menupanels.OrderKiosk;
import org.pluralsight.gui.submenus.SubMenuPanel;

import javax.swing.*;

public class PanelManager {
    private static Window window;
    private static final JPanel[] panels = {
            new WelcomeScreen(),
            new OrderKiosk()
    };

    public static void main(String[] args) {
        window = new Window();
        window.add(panels[0]);
    }

    public static void swap(JPanel newPanel) {
        window.setContentPane(newPanel);
        window.invalidate();
        window.validate();
    }

    public static void repaint() {
        window.invalidate();
        window.validate();
    }

    public static JPanel getPanel(int index) {
        return panels[index];
    }
}
