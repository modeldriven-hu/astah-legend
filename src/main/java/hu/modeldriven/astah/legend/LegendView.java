package hu.modeldriven.astah.legend;

import com.change_vision.jude.api.inf.ui.IPluginExtraTabView;
import com.change_vision.jude.api.inf.ui.ISelectionListener;
import hu.modeldriven.astah.legend.ui.components.LegendPanel;
import hu.modeldriven.core.eventbus.EventBus;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

public class LegendView extends JPanel implements IPluginExtraTabView {

    public LegendView() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        add(createContentPane(), BorderLayout.CENTER);
    }

    private Container createContentPane() {
        EventBus eventBus = new EventBus();
        return new LegendPanel(eventBus);
    }

    @Override
    public void addSelectionListener(ISelectionListener listener) {
        // nothing to do here
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public String getDescription() {
        return "Legend View";
    }

    @Override
    public String getTitle() {
        return "Legend";
    }

    public void activated() {
        // nothing to do here
    }

    public void deactivated() {
        // nothing to do here
    }
}

