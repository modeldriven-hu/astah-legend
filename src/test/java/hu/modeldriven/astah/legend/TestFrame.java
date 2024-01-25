package hu.modeldriven.astah.legend;

import hu.modeldriven.astah.legend.ui.AbstractLegendPanel;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import hu.modeldriven.astah.legend.ui.LegendPanel;
import hu.modeldriven.core.eventbus.EventBus;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class TestFrame {

    private JFrame frame;

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            try {
                UIManager.put("TitlePane.menuBarEmbedded", false);
                FlatLightFlatIJTheme.setup();
                FlatLaf.updateUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        SwingUtilities.invokeLater(() -> {
            try {
                TestFrame window = new TestFrame();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TestFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {
        frame = new JFrame("Simple HTML Text Editor");
        frame.setMinimumSize(new Dimension(763, 300));
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EventBus eventBus = new EventBus();

        JPanel panel = new LegendPanel(frame, eventBus);

        frame.getContentPane().add(panel, BorderLayout.NORTH);
    }

}
