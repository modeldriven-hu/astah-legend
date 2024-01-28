package hu.modeldriven.astah.legend.ui.model;

public enum BorderType {

    SOLID("Solid"), DASHED("Dashed"), DOTTED("Dotted");

    private final String name;

    BorderType(String name) {
        this.name = name;
    }

    public static BorderType getByName(String name) {

        for (BorderType borderType : BorderType.values()) {
            if (borderType.getName().equals(name)) {
                return borderType;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

}
