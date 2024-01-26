package hu.modeldriven.astah.legend.ui.model.impl;

import hu.modeldriven.astah.legend.ui.model.*;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

public class YAMLLegendFile implements LegendFile {

    private final File file;

    public YAMLLegendFile(File file) {
        this.file = file;
    }

    @Override
    public Legend asLegend() throws LegendFileException {
        try (Reader reader = new FileReader(this.file)) {

            LoaderOptions options = new LoaderOptions();
            options.setTagInspector(tag -> false);

            Yaml yaml = new Yaml(options);

            return createLegend(yaml.load(reader));
        } catch (Exception e) {
            throw new LegendFileException(e);
        }
    }

    private Legend createLegend(Map<String, Object> data){

        String name = data.get("legend-name").toString();
        LegendStyle style = createLegendStyle((Map<String, Object>) data.get("legend-style"));
        List<LegendItem> legendItems = createLegendItems((List<Object>) data.get("legend-items"));

        return new Legend(name, style, legendItems);
    }

    private LegendStyle createLegendStyle(Map<String,Object> data){
        Color backgroundColor = Color.decode(data.get("background-color").toString());
        Color borderColor = Color.decode(data.get("border-color").toString());
        int borderWidth = (Integer)data.get("border-width");
        BorderType type = BorderType.valueOf(data.get("border-type").toString());
        BorderFormat format = BorderFormat.valueOf(data.get("format").toString());

        return new LegendStyleImpl(backgroundColor, borderColor,borderWidth,type, format);
    }

    private List<LegendItem> createLegendItems(List<Object> data){
        return data.stream()
                .map(o -> (Map<String, Object>)o)
                .map(this::createLegendItem)
                .collect(Collectors.toList());
    }

    private LegendItem createLegendItem(Map<String,Object> data){

        String id = UUID.randomUUID().toString();
        String name = data.get("name").toString();
        Color backgroundColor = Color.decode(data.get("background-color").toString());
        Color textColor = Color.decode(data.get("text-color").toString());
        String script = data.get("script").toString();

        return new LegendItemImpl(id, name, backgroundColor, textColor,script);
    }

}
