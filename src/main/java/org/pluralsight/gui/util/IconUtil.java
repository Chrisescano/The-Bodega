package org.pluralsight.gui.util;

import javax.swing.*;
import java.awt.*;

public class IconUtil {
    public static ImageIcon scale(String filePath, int width, int height) {
        ImageIcon icon = new ImageIcon(filePath);
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
