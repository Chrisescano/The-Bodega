package org.pluralsight.shop;

public enum Size {
    SMALL("4\""),
    MEDIUM("8\""),
    LARGE("12\"");

    private final String breadSize;

    Size(String breadSize) {
        this.breadSize = breadSize;
    }

    public String getBreadSize() {
        return breadSize;
    }
}
