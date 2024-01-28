package hu.modeldriven.astah.legend.ui.model;

public enum BorderFormat {

    RECTANGLE("Rectangle"), ROUNDED("Rounded rectangle");

    private final String name;

    BorderFormat(String name) {
        this.name = name;
    }

    public static BorderFormat getByName(String name) {
        for (BorderFormat borderFormat : BorderFormat.values()) {
            if (borderFormat.getName().equals(name)) {
                return borderFormat;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

}
