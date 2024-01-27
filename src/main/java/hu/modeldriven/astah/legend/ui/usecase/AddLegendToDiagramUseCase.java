package hu.modeldriven.astah.legend.ui.usecase;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.BlockDefinitionDiagramEditor;
import com.change_vision.jude.api.inf.editor.IDiagramEditorFactory;
import com.change_vision.jude.api.inf.model.IDiagram;
import com.change_vision.jude.api.inf.project.ProjectAccessor;
import hu.modeldriven.astah.core.AstahException;
import hu.modeldriven.astah.core.AstahRepresentation;
import hu.modeldriven.astah.core.AstahRuntimeException;
import hu.modeldriven.astah.core.AstahTransaction;
import hu.modeldriven.astah.legend.ui.event.ApplyLegendRequestedEvent;
import hu.modeldriven.astah.legend.ui.event.ExceptionOccurredEvent;
import hu.modeldriven.astah.legend.ui.model.Legend;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.awt.geom.Point2D;
import java.util.Collections;
import java.util.List;

public class AddLegendToDiagramUseCase implements EventHandler<ApplyLegendRequestedEvent> {

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

        } catch (Exception e){
            eventBus.publish(new ExceptionOccurredEvent(e));
        }
    }

    private void addLegendToDiagram(BlockDefinitionDiagramEditor editor, Legend legend) throws AstahRuntimeException {
        try {
            editor.createRect(new Point2D.Double(10, 10), 30, 30);
        } catch (Exception e){
            throw new AstahRuntimeException(e);
        }
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ApplyLegendRequestedEvent.class);
    }
}
