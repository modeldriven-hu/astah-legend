package hu.modeldriven.astah.legend.ui.model;

import java.awt.Color;
import java.util.UUID;

public class LegendItem {

    String id;

    String name;

    Color backgroundColor;

    Color textColor;

    String script;

    public LegendItem() {
        this.id = UUID.randomUUID().toString();
        this.name = "Item";
    }

    public LegendItem(String id, String name, Color backgroundColor, Color textColor, String script) {
        this.id = id;
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.script = script;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public String getScript() {
        return script;
    }

}
