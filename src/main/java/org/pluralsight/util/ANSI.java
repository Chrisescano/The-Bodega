package org.pluralsight.util;

public enum ANSI {
    RESET(0),

    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36);

    private final int terminalCode;

    ANSI(int terminalCode) {
        this.terminalCode = terminalCode;
    }

    public String getTerminalCode() {
        return "\u001B[" + terminalCode + "m";
    }
}
