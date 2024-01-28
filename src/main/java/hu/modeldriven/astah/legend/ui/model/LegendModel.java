package hu.modeldriven.astah.legend.ui.model;

import hu.modeldriven.astah.legend.ui.event.*;
import hu.modeldriven.astah.legend.ui.model.impl.LegendImpl;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The model is a view based on the incoming events. As
 * the events arrive, we are modifying the internal state.
 * A nicer solution would be to always recreate the internal
 * representation making the whole system truly immutable.
 */
public class LegendModel implements EventHandler<Event> {

    private LegendImpl legend;

    public LegendModel() {
        this.legend = new LegendImpl();
    }

    @Override
    public void handleEvent(Event event) {

        if (event instanceof ResetRequestedEvent) {
            handleResetRequested();
        }

        if (event instanceof LegendNameChangedEvent) {
            handleLegendNameChanged((LegendNameChangedEvent) event);
        }

        if (event instanceof LegendStyleModifiedEvent) {
            handleLegendStyleModified ((LegendStyleModifiedEvent)event);
        }

        if (event instanceof LegendItemCreatedEvent) {
            handleLegendItemCreated((LegendItemCreatedEvent)event);
        }

        if (event instanceof LegendItemModifiedEvent) {
            handleLegendItemModified((LegendItemModifiedEvent) event);
        }

        if (event instanceof LegendItemRemovedEvent) {
            handleLegendItemRemoved((LegendItemRemovedEvent)event);
        }

        if (event instanceof LegendItemReorganizedEvent) {
            handleLegendItemReorganized((LegendItemReorganizedEvent)event);
        }

    }

    private void handleResetRequested(){
        this.legend = new LegendImpl();
    }

    private void handleLegendNameChanged(LegendNameChangedEvent e){
        this.legend.setName(e.getName());
    }

    private void handleLegendStyleModified(LegendStyleModifiedEvent e){
        this.legend.setStyle(e.getLegendStyle());
    }

    private void handleLegendItemCreated(LegendItemCreatedEvent e){
        this.legend.getLegendItems().add(e.getLegendItem());
    }

    private void handleLegendItemRemoved(LegendItemRemovedEvent e){
        this.legend.getLegendItems().removeIf(item -> matches(item, e.getLegendItem()));
    }

    private void handleLegendItemModified(LegendItemModifiedEvent e){

        List<LegendItem> items = this.legend.getLegendItems();

        for (int i = 0; i < items.size(); i++) {
            if (matches(items.get(i), e.getLegendItem())) {
                items.set(i, e.getLegendItem());
                break;
            }
        }
    }

    private void handleLegendItemReorganized(LegendItemReorganizedEvent e) {
        List<LegendItem> items = this.legend.getLegendItems();

        for (int index = 0; index < items.size(); index++) {
            if (matches(items.get(index), e.getLegendItem())) {
                if (e.getDirection().equals(LegendItemReorganizedEvent.Direction.UP) && index > 0) {
                    Collections.swap(items, index, index - 1);
                } else if (index < items.size() - 1) {
                    Collections.swap(items, index, index + 1);
                }
            }
        }

    }

    private boolean matches(LegendItem a, LegendItem b) {
        return a.getId().equals(b.getId());
    }

    public Legend getLegend() {
        return legend;
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Arrays.asList(
                LegendNameChangedEvent.class,
                ResetRequestedEvent.class,
                LegendStyleModifiedEvent.class,
                LegendItemCreatedEvent.class,
                LegendItemModifiedEvent.class,
                LegendItemRemovedEvent.class,
                LegendItemReorganizedEvent.class
        );
    }
}
