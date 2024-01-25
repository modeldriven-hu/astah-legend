package hu.modeldriven.astah.legend.ui;

import hu.modeldriven.core.eventbus.EventBus;

import java.awt.Component;

public class LegendPanel extends AbstractLegendPanel{

    private final Component parentComponent;
    private final EventBus eventBus;

    public LegendPanel(Component parentComponent, EventBus eventBus){
        super();
        this.parentComponent = parentComponent;
        this.eventBus = eventBus;
    }

}
