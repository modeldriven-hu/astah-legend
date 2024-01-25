package hu.modeldriven.astah.legend.ui.event;

import hu.modeldriven.astah.legend.ui.LegendItemTableModel;
import hu.modeldriven.astah.legend.ui.model.LegendItem;
import hu.modeldriven.core.eventbus.Event;

public class ReorganizeLegendItemRequestedEvent implements Event {

    private final LegendItem legendItem;
    private final Direction direction;

    public ReorganizeLegendItemRequestedEvent(LegendItem legendItem, Direction direction) {
        this.legendItem = legendItem;
        this.direction = direction;
    }

    public LegendItem getLegendItem() {
        return legendItem;
    }

    public Direction getDirection() {
        return direction;
    }

    public enum Direction {
        UP, DOWN
    }
}
