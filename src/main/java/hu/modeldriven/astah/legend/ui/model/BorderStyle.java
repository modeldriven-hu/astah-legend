package hu.modeldriven.astah.legend.ui.model;

public enum BorderStyle {

    SOLID("Solid"), DASHED("Dashed"), DOTTED("Dotted");

    private final String name;

    BorderStyle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
