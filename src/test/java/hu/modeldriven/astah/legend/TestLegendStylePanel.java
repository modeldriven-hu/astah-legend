package hu.modeldriven.astah.legend;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import hu.modeldriven.astah.legend.ui.components.AbstractMigLegendStylePanel;

import javax.swing.*;
import java.awt.BorderLayout;

public class TestLegendStylePanel {
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
                TestLegendStylePanel window = new TestLegendStylePanel();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TestLegendStylePanel() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    protected void initialize() {
        frame = new JFrame("Simple HTML Text Editor");
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new AbstractMigLegendStylePanel();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
    }

}
