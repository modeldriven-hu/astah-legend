package hu.modeldriven.astah.core.palette;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class WinterPalette implements Palette {

    final List<PaletteItem> items;

    public WinterPalette() {
        this.items = initColors();
    }

    List<PaletteItem> initColors() {

        return Arrays.asList(
                new PaletteItem(new Color(0, 0, 0), "black"),
                new PaletteItem(new Color(153, 153, 153), "nobel"),
                new PaletteItem(new Color(162, 172, 175), "gull grey"),
                new PaletteItem(new Color(230, 230, 230), "gainsboro"),
                new PaletteItem(new Color(255, 255, 255), "white")
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
