package hu.modeldriven.astah.core.palette;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class PassionPalette implements Palette {

    final List<PaletteItem> items;

    public PassionPalette() {
        this.items = initColors();
    }

    List<PaletteItem> initColors() {

        return Arrays.asList(
                // Passion
                new PaletteItem(new Color(255, 41, 102), "radical red"),
                new PaletteItem(new Color(255, 204, 41), "sunglow"),
                new PaletteItem(new Color(153, 255, 102), "screamin' green"),
                new PaletteItem(new Color(41, 204, 255), "deep sky blue"),
                new PaletteItem(new Color(153, 153, 255), "light slate blue")
        );
    }

    @Override
    public PaletteItem getDefault() {
        return new PaletteItem(new Color(0x00, 0x00, 0x00), "black");
    }

    @Override
    public List<PaletteItem> getItems() {
        return this.items;
    }
}
