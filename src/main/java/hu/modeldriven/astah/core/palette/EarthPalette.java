package hu.modeldriven.astah.core.palette;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class EarthPalette implements Palette {

    final List<PaletteItem> items;

    public EarthPalette() {
        this.items = initColors();
    }

    List<PaletteItem> initColors() {

        return Arrays.asList(
                new PaletteItem(new Color(153, 102, 41), "afghan tan"),
                new PaletteItem(new Color(204, 204, 102), "wild willow"),
                new PaletteItem(new Color(255, 204, 102), "grandis"),
                new PaletteItem(new Color(255, 204, 41), "sunglow"),
                new PaletteItem(new Color(204, 102, 0), "tenne")
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
