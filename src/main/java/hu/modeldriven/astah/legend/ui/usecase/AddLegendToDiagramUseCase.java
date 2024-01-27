package hu.modeldriven.astah.legend.ui.usecase;

import com.change_vision.jude.api.inf.editor.BlockDefinitionDiagramEditor;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.presentation.INodePresentation;
import com.change_vision.jude.api.inf.presentation.PresentationPropertyConstants.Key;
import hu.modeldriven.astah.core.AstahFont;
import hu.modeldriven.astah.core.AstahRepresentation;
import hu.modeldriven.astah.core.exception.AstahRuntimeException;
import hu.modeldriven.astah.core.transaction.AstahTransaction;
import hu.modeldriven.astah.legend.ui.event.ApplyLegendRequestedEvent;
import hu.modeldriven.astah.legend.ui.event.ExceptionOccurredEvent;
import hu.modeldriven.astah.legend.ui.model.BorderFormat;
import hu.modeldriven.astah.legend.ui.model.BorderType;
import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.astah.legend.ui.model.impl.HexColor;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddLegendToDiagramUseCase implements EventHandler<ApplyLegendRequestedEvent> {

    private final Font headerFont = new Font("Dialog", Font.BOLD, 16);
    private final Font itemFont = new Font("Dialog", Font.BOLD, 12);
    private static final int ITEM_BOX_SIZE = 30;
    private static final int MARGIN = 5;
    private static final int ITEM_TEXT_GAP = 5;
    private static final int HEADER_GAP = 15;
    private static final int ITEM_GAP = 5;

    private final EventBus eventBus;
    private final AstahRepresentation astah;

    public AddLegendToDiagramUseCase(EventBus eventBus, AstahRepresentation astah) {
        this.eventBus = eventBus;
        this.astah = astah;
    }

    @Override
    public void handleEvent(ApplyLegendRequestedEvent event) {
        try {

            AstahTransaction transaction = new AstahTransaction();
            transaction.execute(() -> addLegendToDiagram(astah.getDiagramEditor(), event.getLegend()));

        } catch (Exception e) {
            eventBus.publish(new ExceptionOccurredEvent(e));
        }
    }

    private void addLegendToDiagram(BlockDefinitionDiagramEditor editor, Legend legend) throws AstahRuntimeException {
        try {

            Point2D.Double topLeftPoint = new Point2D.Double(100, 100);

            drawLegendRectangle(editor, legend, topLeftPoint);
            drawLegendContent(editor, legend, topLeftPoint);

        } catch (Exception e) {
            throw new AstahRuntimeException(e);
        }
    }

    private void drawLegendContent(BlockDefinitionDiagramEditor editor, Legend legend, Point2D topLeftPoint) throws InvalidEditingException {
        drawLegendHeader(editor, legend, topLeftPoint);
        drawLegendItems(editor, legend, topLeftPoint);
    }

    private void drawLegendHeader(BlockDefinitionDiagramEditor editor, Legend legend, Point2D topLeftPoint) throws InvalidEditingException {
        int legendWidth = calculateLegendWidth(itemFont, legend);

        TextLayout textLayout = createTextLayout(headerFont, legend.getName());
        int textWidth = Math.round(textLayout.getAdvance());

        Point2D headerPoint = new Point2D.Double(
                topLeftPoint.getX() + (legendWidth - textWidth) / 2,
                topLeftPoint.getY() + MARGIN);

        INodePresentation labelPresentation = editor.createText(legend.getName(), headerPoint);
        setFontForLabel(labelPresentation, headerFont);
    }

    private void drawLegendItems(BlockDefinitionDiagramEditor editor, Legend legend, Point2D topLeftPoint) throws InvalidEditingException {

        TextLayout headerTextLayout = createTextLayout(headerFont, legend.getName());

        double x = topLeftPoint.getX() + MARGIN;
        double y = topLeftPoint.getY() + MARGIN + headerTextLayout.getBounds().getHeight() + HEADER_GAP;

        for (LegendItem item : legend.getLegendItems()) {

            // Create rectangle with proper color

            INodePresentation legendItemPresentation = editor.createRect(new Point2D.Double(x,y), ITEM_BOX_SIZE, ITEM_BOX_SIZE);

            legendItemPresentation.setProperty(
                    Key.FILL_COLOR,
                    new HexColor(item.getBackgroundColor()).toString());

            legendItemPresentation.setProperty(
                    Key.LINE_COLOR,
                    new HexColor(Color.BLACK).toString());

            // Add label

            double labelHeight = createTextLayout(itemFont, item.getName()).getBounds().getHeight();

            double labelX = x + ITEM_BOX_SIZE + ITEM_TEXT_GAP;
            double labelY = y + labelHeight / 2;

            INodePresentation labelPresentation = editor.createText(item.getName(), new Point2D.Double(labelX,labelY));
            setFontForLabel(labelPresentation, itemFont);

            y += ITEM_BOX_SIZE + ITEM_GAP;
        }

    }

    private void setFontForLabel(INodePresentation presentation, Font font) throws InvalidEditingException {
        AstahFont astahFont = new AstahFont(font);
        astahFont.apply(presentation);
    }

    private void drawLegendRectangle(BlockDefinitionDiagramEditor editor, Legend legend, Point2D topLeftPoint) throws InvalidEditingException {
        int legendWidth = calculateLegendWidth(itemFont, legend);
        int legendHeight = calculateLegendHeight(headerFont, legend);

        INodePresentation legendPresentation = editor
                .createRect(topLeftPoint, legendWidth, legendHeight);

        legendPresentation.setProperty(
                Key.FILL_COLOR,
                new HexColor(legend.getStyle().getBackgroundColor()).toString());

        legendPresentation.setProperty(
                Key.LINE_COLOR,
                new HexColor(legend.getStyle().getBorderColor()).toString());

        legendPresentation.setProperty(
                Key.LINE_WIDTH,
                String.valueOf(legend.getStyle().getBorderWidth()));

        if (BorderFormat.ROUNDED.equals(legend.getStyle().getBorderFormat())){
            legendPresentation.setProperty(
                    Key.RECT_TYPE,
                    "round");
        }

        if (BorderType.DASHED.equals(legend.getStyle().getBorderType())){
            legendPresentation.setProperty(
                    Key.LINE_TYPE,
                    "dash1");
        }

        if (BorderType.DOTTED.equals(legend.getStyle().getBorderType())){
            legendPresentation.setProperty(
                    Key.LINE_TYPE,
                    "dash2");
        }
    }

    private int calculateLegendWidth(Font font, Legend legend) {

        List<String> labels = getLegendLabels(legend);

        String longestLabel = labels.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        TextLayout textLayout = createTextLayout(font, longestLabel);

        int textWidth = Math.round(textLayout.getAdvance());

        return MARGIN + ITEM_BOX_SIZE + ITEM_TEXT_GAP + textWidth + MARGIN;
    }

    private int calculateLegendHeight(Font headerFont, Legend legend){

        TextLayout textLayout = createTextLayout(headerFont, legend.getName());

        return MARGIN +
                (int)textLayout.getBounds().getHeight() +
                HEADER_GAP +
                legend.getLegendItems().size()  * ITEM_BOX_SIZE +
                (legend.getLegendItems().size() - 1) * ITEM_GAP +
                MARGIN;
    }

    private TextLayout createTextLayout(Font font, String text){
        FontRenderContext fontRenderContext = new FontRenderContext(null, true, true);

        // TextLayout does not accept empty strings
        return new TextLayout(text.equals("") ? " " : text, font, fontRenderContext);
    }

    private List<String> getLegendLabels(Legend legend){
        return Stream.concat(
                        Stream.of(legend.getName()),
                        legend.getLegendItems().stream().map(LegendItem::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ApplyLegendRequestedEvent.class);
    }
}
