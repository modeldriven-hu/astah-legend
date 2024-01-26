package hu.modeldriven.astah.legend.ui.model.impl;

import hu.modeldriven.astah.legend.ui.model.*;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;

import java.awt.Color;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class YAMLLegendFile implements LegendFile {

    public static final String LEGEND_NAME = "legend-name";
    public static final String LEGEND_STYLE = "legend-style";
    public static final String LEGEND_ITEMS = "legend-items";
    public static final String BACKGROUND_COLOR = "background-color";
    public static final String BORDER_COLOR = "border-color";
    public static final String BORDER_WIDTH = "border-width";
    public static final String BORDER_TYPE = "border-type";
    public static final String BORDER_FORMAT = "border-format";
    public static final String BACKGROUND_COLOR1 = "background-color";
    public static final String TEXT_COLOR = "text-color";
    public static final String SCRIPT = "script";
    public static final String NAME = "name";
    private final File file;
    private final Yaml yaml;

    public YAMLLegendFile(File file) {
        this.file = file;

        LoaderOptions options = new LoaderOptions();
        options.setTagInspector(tag -> false);

        this.yaml = new Yaml(options);
    }

    @Override
    public Legend read() throws LegendFileException {
        try (Reader reader = new FileReader(this.file)) {
            return createLegend(yaml.load(reader));
        } catch (Exception e) {
            throw new LegendFileException(e);
        }
    }

    @Override
    public void write(Legend legend) throws LegendFileException {
        Map<String, Object> legendData = new HashMap<>();

        legendData.put(LEGEND_NAME, Objects.toString(legend.getName(),""));

        LegendStyle legendStyle = legend.getStyle();
        Map<String, Object> legendStyleData = new HashMap<>();
        legendStyleData.put(BACKGROUND_COLOR, toHex(legendStyle.getBackgroundColor()));
        legendStyleData.put(BORDER_COLOR, toHex(legendStyle.getBorderColor()));
        legendStyleData.put(BORDER_WIDTH, legendStyle.getBorderWidth());
        legendStyleData.put(BORDER_TYPE, legendStyle.getBorderType().name());
        legendStyleData.put(BORDER_FORMAT, legendStyle.getBorderFormat().name());

        legendData.put(LEGEND_STYLE, legendStyleData);

        List<Map<String, Object>> legendItemsData = new ArrayList<>();

        for (LegendItem legendItem : legend.getLegendItems()) {

            Map<String, Object> legendItemData = new HashMap<>();

            legendItemData.put(NAME, Objects.toString(legendItem.getName(),""));
            legendItemData.put(BACKGROUND_COLOR, toHex(legendItem.getBackgroundColor()));
            legendItemData.put(TEXT_COLOR, toHex(legendItem.getTextColor()));
            legendItemData.put(SCRIPT, Objects.toString(legendItem.getScript(),""));

            legendItemsData.add(legendItemData);
        }

        legendData.put(LEGEND_ITEMS, legendItemsData);

        try {
            String yamlAsString = yaml.dump(legendData);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(yamlAsString);
            writer.close();

        } catch (Exception e) {
            throw new LegendFileException(e);
        }
    }

    private String toHex(Color color) {
        String hex = "#" + Integer.toHexString(color.getRGB()).substring(2);
        return hex.toUpperCase();
    }

    private Legend createLegend(Map<String, Object> data) {

        String name = data.get(LEGEND_NAME).toString();
        LegendStyle style = createLegendStyle((Map<String, Object>) data.get(LEGEND_STYLE));
        List<LegendItem> legendItems = createLegendItems((List<Object>) data.get(LEGEND_ITEMS));

        return new Legend(name, style, legendItems);
    }

    private LegendStyle createLegendStyle(Map<String, Object> data) {
        Color backgroundColor = Color.decode(data.get(BACKGROUND_COLOR).toString());
        Color borderColor = Color.decode(data.get(BORDER_COLOR).toString());
        int borderWidth = (Integer) data.get(BORDER_WIDTH);
        BorderType type = BorderType.valueOf(data.get(BORDER_TYPE).toString());
        BorderFormat format = BorderFormat.valueOf(data.get(BORDER_FORMAT).toString());

        return new LegendStyleImpl(backgroundColor, borderColor, borderWidth, type, format);
    }

    private List<LegendItem> createLegendItems(List<Object> data) {
        return data.stream()
                .map(o -> (Map<String, Object>) o)
                .map(this::createLegendItem)
                .collect(Collectors.toList());
    }

    private LegendItem createLegendItem(Map<String, Object> data) {

        String id = UUID.randomUUID().toString();
        String name = data.get(NAME).toString();
        Color backgroundColor = Color.decode(data.get(BACKGROUND_COLOR1).toString());
        Color textColor = Color.decode(data.get(TEXT_COLOR).toString());
        String script = data.get(SCRIPT).toString();

        return new LegendItemImpl(id, name, backgroundColor, textColor, script);
    }

}
