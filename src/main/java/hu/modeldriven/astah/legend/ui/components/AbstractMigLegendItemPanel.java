package hu.modeldriven.astah.legend.ui.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class AbstractMigLegendItemPanel extends JPanel {

    public AbstractMigLegendItemPanel() {
        super();

        Font labelFont = getFont();

        setLayout(new MigLayout("fillx, hidemode 3",
                "[fill]",
                "[][][]"));

        infoPanel = new JPanel(new MigLayout("", "", "[]20[]"));
        infoPanel.setBackground(Color.WHITE);

        JLabel headerLabel = new JLabel("Legend item");
        headerLabel.setFont(labelFont.deriveFont(Font.BOLD, 18f));
        infoPanel.add(headerLabel, "wrap");

        JLabel additionalInfoLabel = new JLabel("Configure the legend item!");
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

        JLabel label0 = new JLabel("Name:");
        label0.setFont(labelFont);
        contentPanel.add(label0, "cell 0 0");

        nameField = new JTextField();
        contentPanel.add(nameField, "cell 1 0");

        JLabel label1 = new JLabel("Background color:");
        label1.setFont(labelFont);
        contentPanel.add(label1, "cell 0 1");

        backgroundColorPanel = new JPanel();
        backgroundColorPanel.setPreferredSize(new Dimension(120, 20));
        backgroundColorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPanel.add(backgroundColorPanel, "cell 1 1");

        backgroundColorButton = new JButton("Select...");
        contentPanel.add(backgroundColorButton, "cell 2 1");

        JLabel label2 = new JLabel("Text color:");
        label2.setFont(labelFont);
        contentPanel.add(label2, "cell 0 2");

        textColorPanel = new JPanel();
        textColorPanel.setPreferredSize(new Dimension(120, 20));
        textColorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPanel.add(textColorPanel, "cell 1 2");

        textColorButton = new JButton("Select...");
        contentPanel.add(textColorButton, "cell 2 2");

        JLabel label3 = new JLabel("Script:");
        label3.setFont(labelFont);
        contentPanel.add(label3, "cell 0 3");

        scriptTextField = new JTextArea();
        scriptTextField.setColumns(20);
        scriptTextField.setRows(5);

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(scriptTextField);

        contentPanel.add(scrollPane, "cell 1 3 2 1");

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
        frame.getContentPane().add(BorderLayout.CENTER, new AbstractMigLegendItemPanel());
        frame.pack();
        frame.setVisible(true);
    }

    protected javax.swing.JButton backgroundColorButton;
    protected javax.swing.JPanel backgroundColorPanel;
    protected javax.swing.JButton textColorButton;
    protected javax.swing.JPanel textColorPanel;
    private javax.swing.JPanel buttonPanel;
    protected javax.swing.JButton cancelButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel infoPanel;
    protected javax.swing.JButton okButton;
    protected JTextField nameField;
    protected javax.swing.JTextArea scriptTextField;
    protected javax.swing.JScrollPane scrollPane;

}
