package hu.modeldriven.astah.core.palette;

import java.util.List;

public interface Palette {

    List<PaletteItem> getItems();

    PaletteItem getDefault();

}
