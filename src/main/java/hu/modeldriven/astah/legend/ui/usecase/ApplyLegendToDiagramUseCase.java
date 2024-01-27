package hu.modeldriven.astah.legend.ui.usecase;

import com.change_vision.jude.api.inf.model.IDiagram;
import com.change_vision.jude.api.inf.presentation.IPresentation;
import com.change_vision.jude.api.inf.presentation.PresentationPropertyConstants.Key;
import hu.modeldriven.astah.core.AstahRepresentation;
import hu.modeldriven.astah.core.exception.AstahRuntimeException;
import hu.modeldriven.astah.core.transaction.AstahTransaction;
import hu.modeldriven.astah.legend.ui.event.ApplyLegendRequestedEvent;
import hu.modeldriven.astah.legend.ui.event.ExceptionOccurredEvent;
import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.astah.legend.ui.model.impl.HexColor;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;
import hu.modeldriven.core.groovy.GroovyScriptExecutor;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplyLegendToDiagramUseCase implements EventHandler<ApplyLegendRequestedEvent> {

    private final EventBus eventBus;
    private final GroovyScriptExecutor executor;
    private final AstahRepresentation astah;

    public ApplyLegendToDiagramUseCase(EventBus eventBus, AstahRepresentation astah) {
        this.eventBus = eventBus;
        this.executor = new GroovyScriptExecutor();
        this.astah = astah;
    }

    @Override
    public void handleEvent(ApplyLegendRequestedEvent event) {
        try {
            IDiagram diagram = astah.getCurrentDiagram();

            if (diagram == null) {

                JOptionPane.showMessageDialog(null,
                        "Please open the diagram!",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE);

                return;
            }

            AstahTransaction transaction = new AstahTransaction();
            transaction.execute(() -> applyLegendOnDiagram(diagram, event.getLegend()));

        } catch (Exception e) {
            eventBus.publish(new ExceptionOccurredEvent(e));
        }
    }

    private void applyLegendOnDiagram(IDiagram diagram, Legend legend) throws AstahRuntimeException {

        try {

            for (IPresentation presentation : diagram.getPresentations()) {

                for (LegendItem legendItem : legend.getLegendItems()) {

                    if (isMatching(presentation, legendItem)) {

                        presentation.setProperty(
                                Key.FILL_COLOR,
                                new HexColor(legendItem.getBackgroundColor()).toString());

                        presentation.setProperty(
                                Key.FONT_COLOR,
                                new HexColor(legendItem.getTextColor()).toString());

                    }
                }
            }

        } catch (Exception e) {
            throw new AstahRuntimeException(e);
        }
    }

    public boolean isMatching(IPresentation presentation, LegendItem legendItem) throws Exception {

        if (legendItem.ignorePresentation() && presentation.getModel() == null) {
            return false;
        }

        Map<String, Object> arguments = new HashMap<>();
        arguments.put("presentation", presentation);
        arguments.put("element", presentation.getModel());

        Object value = executor.execute(legendItem.getScript(), arguments);

        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue();
        }

        return false;
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ApplyLegendRequestedEvent.class);
    }
}
