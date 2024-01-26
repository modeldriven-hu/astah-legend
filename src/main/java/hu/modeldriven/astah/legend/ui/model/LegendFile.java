package hu.modeldriven.astah.legend.ui.model;

public interface LegendFile {

    Legend read() throws LegendFileException;

    void write(Legend legend) throws LegendFileException;

}
