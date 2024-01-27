package hu.modeldriven.astah.core.palette;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

public class AquaPalette implements Palette {

    final List<PaletteItem> items;

    public AquaPalette() {
        this.items = initColors();
    }

    List<PaletteItem> initColors() {

        return Arrays.asList(

                // Aqua

                new PaletteItem(new Color(204, 204, 255), "lavender blue"),
                new PaletteItem(new Color(153, 204, 255), "columbia blue"),
                new PaletteItem(new Color(153, 153, 255), "light slate blue"),
                new PaletteItem(new Color(41, 102, 255), "dodger blue"),
                new PaletteItem(new Color(41, 41, 255), "han purple"),

                // Earth
                new PaletteItem(new Color(153, 102, 41), "afghan tan"),
                new PaletteItem(new Color(204, 204, 102), "wild willow"),
                new PaletteItem(new Color(255, 204, 102), "grandis"),
                new PaletteItem(new Color(255, 204, 41), "sunglow"),
                new PaletteItem(new Color(204, 102, 0), "tenne"),

                // Nature
                new PaletteItem(new Color(255, 255, 153), "canary"),
                new PaletteItem(new Color(204, 255, 204), "honeydew"),
                new PaletteItem(new Color(102, 255, 41), "bright green"),
                new PaletteItem(new Color(102, 204, 255), "kelly green"),
                new PaletteItem(new Color(204, 255, 255), "light cyan"),

                // Spring
                new PaletteItem(new Color(255, 204, 204), "pink"),
                new PaletteItem(new Color(255, 153, 153), "mona lisa"),
                new PaletteItem(new Color(255, 153, 41), "neon carrot"),
                new PaletteItem(new Color(255, 255, 41), "gorse"),
                new PaletteItem(new Color(255, 255, 204), "cream"),

                // Passion
                new PaletteItem(new Color(255, 41, 102), "radical red"),
                new PaletteItem(new Color(255, 204, 41), "sunglow"),
                new PaletteItem(new Color(153, 255, 102), "screamin' green"),
                new PaletteItem(new Color(41, 204, 255), "deep sky blue"),
                new PaletteItem(new Color(153, 153, 255), "light slate blue"),

                // Winter
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
