package hu.modeldriven.astah.legend.ui.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class AbstractLegendStylePanel extends JPanel {

    private final javax.swing.JPanel buttonPanel;
    private final javax.swing.JPanel contentPanel;
    private final javax.swing.JPanel infoPanel;
    protected javax.swing.JButton backgroundColorButton;
    protected javax.swing.JPanel backgroundColorPanel;
    protected javax.swing.JButton borderColorButton;
    protected javax.swing.JPanel borderColorPanel;
    protected javax.swing.JComboBox<String> borderFormatComboBox;
    protected javax.swing.JComboBox<String> borderTypeComboBox;
    protected javax.swing.JTextField borderWidthTextField;
    protected javax.swing.JButton cancelButton;
    protected javax.swing.JButton okButton;
    public AbstractLegendStylePanel() {
        super();

        Font labelFont = getFont();

        setLayout(new MigLayout("fillx, hidemode 3",
                "[fill]",
                "[][][]"));

        infoPanel = new JPanel(new MigLayout("", "", "[]20[]"));
        infoPanel.setBackground(Color.WHITE);

        JLabel headerLabel = new JLabel("Legend style");
        headerLabel.setFont(labelFont.deriveFont(Font.BOLD, 18f));
        infoPanel.add(headerLabel, "wrap");

        JLabel additionalInfoLabel = new JLabel("Configure the style settings of a legend");
        additionalInfoLabel.setFont(labelFont);
        infoPanel.add(additionalInfoLabel);

        add(infoPanel, "cell 0 0");

        contentPanel = new JPanel(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]" +
                        "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"
        ));

        JLabel label1 = new JLabel("Background color:");
        label1.setFont(labelFont);
        contentPanel.add(label1, "cell 0 0");

        backgroundColorPanel = new JPanel();
        backgroundColorPanel.setPreferredSize(new Dimension(120, 20));
        backgroundColorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPanel.add(backgroundColorPanel, "cell 1 0");

        backgroundColorButton = new JButton("Select...");
        contentPanel.add(backgroundColorButton, "cell 2 0");

        JLabel label2 = new JLabel("Border color:");
        label2.setFont(labelFont);
        contentPanel.add(label2, "cell 0 1");

        borderColorPanel = new JPanel();
        borderColorPanel.setPreferredSize(new Dimension(120, 20));
        borderColorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPanel.add(borderColorPanel, "cell 1 1");

        borderColorButton = new JButton("Select...");
        contentPanel.add(borderColorButton, "cell 2 1");

        JLabel label3 = new JLabel("Border width:");
        label3.setFont(labelFont);
        contentPanel.add(label3, "cell 0 2");

        borderWidthTextField = new JTextField();
        contentPanel.add(borderWidthTextField, "cell 1 2");

        JLabel label4 = new JLabel("px");
        label4.setFont(labelFont);
        contentPanel.add(label4, "cell 2 2");

        JLabel label5 = new JLabel("Border type:");
        label5.setFont(labelFont);
        contentPanel.add(label5, "cell 0 3");

        borderTypeComboBox = new JComboBox<>();
        borderTypeComboBox.addItem("Solid");
        borderTypeComboBox.addItem("Dashed");
        borderTypeComboBox.addItem("Dotted");
        contentPanel.add(borderTypeComboBox, "cell 1 3 2 1");

        JLabel label6 = new JLabel("Format:");
        label6.setFont(labelFont);
        contentPanel.add(label6, "cell 0 4");

        borderFormatComboBox = new JComboBox<>();
        borderFormatComboBox.addItem("Rectangle");
        borderFormatComboBox.addItem("Rounded rectangle");
        contentPanel.add(borderFormatComboBox, "cell 1 4 2 1");

        add(contentPanel, "cell 0 1");

        buttonPanel = new JPanel(new MigLayout("hidemode 3, alignx trailing",
                "[fill][fill]",
                "[]"));

        cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton, "cell 0 0");

        okButton = new JButton("OK");
        buttonPanel.add(okButton, "cell 1 0");

        add(buttonPanel, "cell 0 2");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(BorderLayout.CENTER, new AbstractLegendStylePanel());
        frame.pack();
        frame.setVisible(true);
    }

}
