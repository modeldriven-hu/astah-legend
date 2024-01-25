package hu.modeldriven.astah.legend.ui.model;

import java.awt.Color;
import java.util.UUID;

public class LegendItem {

    String id;

    String name;

    Color backgroundColor;

    Color textColor;

    String script;

    public LegendItem(){
        this.id = UUID.randomUUID().toString();
        this.name = "Item";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
