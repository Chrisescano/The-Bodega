package org.pluralsight.util;

public class TerminalFormat {
    private int msgWidth = 40;
    private String verticalDivider = "|";
    private String horizontalDivider = "-";
    private String anchorDivider = "+";

    /*-----Common Use Methods-----*/
    public String tableRow() {
        return verticalDivider + " ".repeat(msgWidth + 2) + verticalDivider;
    }

    public String tableRow(String text, String padDirection) {
        if (padDirection.equals("center")) text = padEdges(text);
        else if (padDirection.equals("left")) text = padLeft(text);
        else text = padRight(text);
        return verticalDivider + " " + text + " " + verticalDivider;
    }

    public String tableRow(String front, String back, String padDirection) {
        if (padDirection.equals("between")) front = padInBetween(front, back);
        return verticalDivider + " " + front + " " + verticalDivider;
    }

    public String divider() {
        return anchorDivider + "--" + line() + anchorDivider;
    }

    /*-----Helper Methods-----*/
    public String padRight(String text) {
        return text + " ".repeat(msgWidth - text.length());
    }

    public String padEdges(String text) {
        int textLength;
        if ((textLength = text.length()) >= msgWidth) return text; //no need to center
        int startingPoint = (msgWidth - textLength) / 2;
        return " ".repeat(startingPoint) + text + " ".repeat(msgWidth - startingPoint - textLength);
    }

    public String padLeft(String text) {
        int textLength;
        if ((textLength = text.length()) >= msgWidth) return text; //no need to center
        return " ".repeat(msgWidth - textLength) + text;
    }

    public String padInBetween(String frontText, String backText) {
        int frontLength = frontText.length();
        int backLength = backText.length();
        if(frontLength + backLength >= msgWidth) return frontText + backText;
        int amountOfPadding = msgWidth - backLength - frontLength;
        return frontText + " ".repeat(amountOfPadding) + backText;
    }

    public String line() {
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

    /*-----Getters-----*/
    public String getAnchorDivider() {
        return anchorDivider;
    }
}
