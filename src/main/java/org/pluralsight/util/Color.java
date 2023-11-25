package org.pluralsight.util;

public class Color{

    public String colorize(String color, String message) {
        return toANSI(color) + message + ANSI.RESET.getTerminalCode();
    }

    private String toANSI(String color) {
        try {
            return ANSI.valueOf(color.toUpperCase()).getTerminalCode();
        } catch (IllegalArgumentException e) {
            return "";
        }
    }
}
