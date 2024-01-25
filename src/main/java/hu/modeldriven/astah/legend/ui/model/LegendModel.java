package hu.modeldriven.astah.legend.ui.model;

import hu.modeldriven.astah.legend.ui.event.*;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
import hu.modeldriven.core.eventbus.EventHandler;

import java.util.Collections;
import java.util.List;

/**
 * The model is a view based on the incoming events. As
 * the events arrive, we are modifying the internal state.
 * A nicer solution would be to always recreate the internal
 * representation making the whole system truly immutable.
 */
public class LegendModel implements EventHandler<Event>{

    private final EventBus eventBus;

    private Legend legend;

    public LegendModel(EventBus eventBus) {
        this.eventBus = eventBus;
        this.legend = new Legend();
        this.legend.setStyle(new LegendStyle());
    }

    @Override
    public void handleEvent(Event event) {

        if (event instanceof ResetRequestedEvent) {
            this.legend = new Legend();
        }
        
        if (event instanceof LegendStyleModifiedEvent){
            LegendStyleModifiedEvent e = (LegendStyleModifiedEvent)event;
            this.legend.setStyle(e.getLegendStyle());
        }

        if (event instanceof LegendItemCreatedEvent){
            LegendItemCreatedEvent e = (LegendItemCreatedEvent)event;
            this.legend.getLegendItems().add(e.getLegendItem());
        }

        if (event instanceof LegendItemModifiedEvent){
            LegendItemModifiedEvent e = (LegendItemModifiedEvent)event;

            List<LegendItem> items = this.legend.getLegendItems();

            for (int i = 0; i < items.size(); i++){
                if (items.get(i).getId().equals(e.getLegendItem().getId())){
                    items.set(i, e.getLegendItem());
                    break;
                }
            }

        }

        if (event instanceof LegendItemRemovedEvent){
            LegendItemRemovedEvent e = (LegendItemRemovedEvent)event;
            this.legend.getLegendItems().removeIf(item -> e.getLegendItem().getId().equals(item.getId()));
        }

        if (event instanceof LegendItemReorganizedEvent){
            LegendItemReorganizedEvent e = (LegendItemReorganizedEvent)event;
        }

    }

    public Legend getLegend() {
        return legend;
    }

    @Override
    public List<Class<? extends Event>> subscribedEvents() {
        return Collections.singletonList(ResetRequestedEvent.class);
    }
}
