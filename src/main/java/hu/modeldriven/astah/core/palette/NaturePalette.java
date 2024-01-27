package hu.modeldriven.astah.core.palette;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class NaturePalette implements Palette {

    final List<PaletteItem> items;

    public NaturePalette() {
        this.items = initColors();
    }

    List<PaletteItem> initColors() {

        return Arrays.asList(
                new PaletteItem(new Color(255, 255, 153), "canary"),
                new PaletteItem(new Color(204, 255, 204), "honeydew"),
                new PaletteItem(new Color(102, 255, 41), "bright green"),
                new PaletteItem(new Color(102, 204, 255), "kelly green"),
                new PaletteItem(new Color(204, 255, 255), "light cyan")
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
