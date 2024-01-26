package hu.modeldriven.astah.legend.ui.model.impl;

import hu.modeldriven.astah.legend.ui.model.LegendItem;

import java.awt.Color;
import java.util.UUID;

public class LegendItemImpl implements LegendItem {

    String id;

    String name;

    Color backgroundColor;

    Color textColor;

    String script;

    public LegendItemImpl() {
        this.id = UUID.randomUUID().toString();
        this.name = "Item";
    }

    public LegendItemImpl(String id, String name, Color backgroundColor, Color textColor, String script) {
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
