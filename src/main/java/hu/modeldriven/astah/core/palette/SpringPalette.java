package hu.modeldriven.astah.core.palette;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class SpringPalette implements Palette {

    final List<PaletteItem> items;

    public SpringPalette() {
        this.items = initColors();
    }

    List<PaletteItem> initColors() {

        return Arrays.asList(
                // Spring
                new PaletteItem(new Color(255, 204, 204), "pink"),
                new PaletteItem(new Color(255, 153, 153), "mona lisa"),
                new PaletteItem(new Color(255, 153, 41), "neon carrot"),
                new PaletteItem(new Color(255, 255, 41), "gorse"),
                new PaletteItem(new Color(255, 255, 204), "cream")
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
