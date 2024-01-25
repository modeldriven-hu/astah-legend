package hu.modeldriven.astah.legend.ui.model;

public enum BorderType {

    SOLID("Solid"), DASHED("Dashed"), DOTTED("Dotted");

    private final String name;

    BorderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
