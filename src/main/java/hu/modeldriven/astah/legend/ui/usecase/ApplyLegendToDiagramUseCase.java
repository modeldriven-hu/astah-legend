package hu.modeldriven.astah.legend.ui.usecase;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.InvalidUsingException;
import com.change_vision.jude.api.inf.model.IDiagram;
import com.change_vision.jude.api.inf.presentation.IPresentation;
import com.change_vision.jude.api.inf.presentation.PresentationPropertyConstants;
import hu.modeldriven.astah.core.AstahTransaction;
import hu.modeldriven.astah.legend.ui.event.ApplyLegendRequestedEvent;
import hu.modeldriven.astah.legend.ui.event.ExceptionOccurredEvent;
import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class ApplyLegendToDiagramUseCase implements EventHandler<ApplyLegendRequestedEvent> {

    private final EventBus eventBus;

    public ApplyLegendToDiagramUseCase(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void handleEvent(ApplyLegendRequestedEvent event) {
        try {
            IDiagram diagram = getCurrentDiagram();

            if (diagram == null) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please open the diagram!",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }

            AstahTransaction transaction = new AstahTransaction();

            transaction.execute(() -> {
                try {
                    applyLegendOnDiagram(diagram, event.getLegend());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (Exception e) {
            eventBus.publish(new ExceptionOccurredEvent(e));
        }
    }

    private void applyLegendOnDiagram(IDiagram diagram, Legend legend) throws InvalidUsingException, InvalidEditingException {

        for (IPresentation presentation : diagram.getPresentations()) {
            presentation.setProperty(PresentationPropertyConstants.Key.FILL_COLOR, "#ff3366");
        }
    }

    IDiagram getCurrentDiagram() throws Exception {
        return AstahAPI.getAstahAPI()
                .getViewManager()
                .getDiagramViewManager()
                .getCurrentDiagram();
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ApplyLegendRequestedEvent.class);
    }
}
