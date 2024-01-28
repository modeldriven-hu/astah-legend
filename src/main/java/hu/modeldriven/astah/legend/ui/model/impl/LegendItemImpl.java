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

    boolean ignorePresentation;

    public LegendItemImpl(Color backgroundColor) {
        this.id = UUID.randomUUID().toString();
        this.name = "Item";
        this.backgroundColor = backgroundColor;
        this.textColor = Color.black;
        this.script = "true";
        this.ignorePresentation = true;
    }

    public LegendItemImpl(String id, String name, Color backgroundColor, Color textColor, String script, boolean ignorePresentation) {
        this.id = id;
        this.name = name;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.script = script;
        this.ignorePresentation = ignorePresentation;
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

    @Override
    public boolean ignorePresentation() {
        return ignorePresentation;
    }

}
