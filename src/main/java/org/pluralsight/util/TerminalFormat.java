package org.pluralsight.util;

public class TerminalFormat {
    private int msgWidth = 30;
    private String verticalDivider = "|";
    private String horizontalDivider = "-";
    private String anchorDivider = "+";

    public String leftAlign(String text) {
        return text + " ".repeat(msgWidth - text.length());
    }

    public String centerAlign(String text) {
        int textLength;
        if ((textLength = text.length()) >= msgWidth) return text; //no need to center
        int startingPoint = (msgWidth - textLength) / 2;
        return " ".repeat(startingPoint) + text + " ".repeat(msgWidth - startingPoint - textLength);
    }

    public String rightAlign(String text) {
        int textLength;
        if ((textLength = text.length()) >= msgWidth) return text; //no need to center
        return " ".repeat(msgWidth - textLength) + text;
    }

    public String lineDivider() {
        return horizontalDivider.repeat(msgWidth);
    }

    /*-----Setters-----*/
    public void setWidth(int msgWidth) {
        this.msgWidth = msgWidth;
    }

    public void setVerticalDivider(char divider) {
        verticalDivider = String.valueOf(divider);
    }

    public void setHorizontalDivider(char divider) {
        horizontalDivider = String.valueOf(divider);
    }

    public void setAnchorDivider(char divider) {
        anchorDivider = String.valueOf(divider);
    }
}
