package hu.modeldriven.astah.legend.ui.model;

import hu.modeldriven.astah.legend.ui.event.*;
import hu.modeldriven.core.eventbus.Event;
import hu.modeldriven.core.eventbus.EventBus;
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

    private final EventBus eventBus;

    private Legend legend;

    public LegendModel(EventBus eventBus) {
        this.eventBus = eventBus;
        this.legend = new Legend();
    }

    @Override
    public void handleEvent(Event event) {

        List<LegendItem> items = this.legend.getLegendItems();

        if (event instanceof ResetRequestedEvent) {
            this.legend = new Legend();
        }

        if (event instanceof LegendNameChangedEvent) {
            LegendNameChangedEvent e = (LegendNameChangedEvent) event;
            this.legend.setName(e.getName());
        }

        if (event instanceof LegendStyleModifiedEvent) {
            LegendStyleModifiedEvent e = (LegendStyleModifiedEvent) event;
            this.legend.setStyle(e.getLegendStyle());
        }

        if (event instanceof LegendItemCreatedEvent) {
            LegendItemCreatedEvent e = (LegendItemCreatedEvent) event;
            items.add(e.getLegendItem());
        }

        if (event instanceof LegendItemModifiedEvent) {
            LegendItemModifiedEvent e = (LegendItemModifiedEvent) event;

            for (int i = 0; i < items.size(); i++) {
                if (matches(items.get(i), e.getLegendItem())) {
                    items.set(i, e.getLegendItem());
                    break;
                }
            }
        }

        if (event instanceof LegendItemRemovedEvent) {
            LegendItemRemovedEvent e = (LegendItemRemovedEvent) event;
            this.legend.getLegendItems().removeIf(item -> matches(item, e.getLegendItem()));
        }

        if (event instanceof LegendItemReorganizedEvent) {
            LegendItemReorganizedEvent e = (LegendItemReorganizedEvent) event;

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
