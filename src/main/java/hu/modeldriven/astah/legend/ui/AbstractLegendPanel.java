/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hu.modeldriven.astah.legend.ui;

/**
 *
 * @author zsolt
 */
public class AbstractLegendPanel extends javax.swing.JPanel {

    /**
     * Creates new form AbstractLegendPanel
     */
    public AbstractLegendPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        toolBar = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        openButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        buttonSeparator = new javax.swing.JToolBar.Separator();
        applyLegendButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        legendPanel = new javax.swing.JPanel();
        legendNameLabel = new javax.swing.JLabel();
        legendNameTextField = new javax.swing.JTextField();
        legendStyleLabel = new javax.swing.JLabel();
        configureLegendStyleButton = new javax.swing.JButton();
        legendItemPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        legendItemTable = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        topPanel.setPreferredSize(new java.awt.Dimension(0, 30));
        topPanel.setLayout(new java.awt.BorderLayout());

        toolBar.setFloatable(true);
        toolBar.setRollover(true);

        newButton.setText("New");
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        toolBar.add(newButton);

        openButton.setText("Open");
        openButton.setFocusable(false);
        openButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(openButton);

        saveButton.setText("Save");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(saveButton);
        toolBar.add(buttonSeparator);

        applyLegendButton.setText("Apply on diagram");
        applyLegendButton.setFocusable(false);
        applyLegendButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        applyLegendButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        applyLegendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyLegendButtonActionPerformed(evt);
            }
        });
        toolBar.add(applyLegendButton);

        topPanel.add(toolBar, java.awt.BorderLayout.CENTER);

        add(topPanel, java.awt.BorderLayout.NORTH);

        contentPanel.setLayout(new java.awt.BorderLayout());

        legendPanel.setBackground(new java.awt.Color(255, 255, 255));

        legendNameLabel.setText("Name:");

        legendStyleLabel.setText("Style:");

        configureLegendStyleButton.setText("Configure...");

        javax.swing.GroupLayout legendPanelLayout = new javax.swing.GroupLayout(legendPanel);
        legendPanel.setLayout(legendPanelLayout);
        legendPanelLayout.setHorizontalGroup(
            legendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(legendPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(legendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(legendNameLabel)
                    .addComponent(legendStyleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(legendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(legendPanelLayout.createSequentialGroup()
                        .addComponent(legendNameTextField)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(legendPanelLayout.createSequentialGroup()
                        .addComponent(configureLegendStyleButton)
                        .addContainerGap(818, Short.MAX_VALUE))))
        );
        legendPanelLayout.setVerticalGroup(
            legendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(legendPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(legendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(legendNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(legendNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(legendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(configureLegendStyleButton)
                    .addComponent(legendStyleLabel))
                .addContainerGap(245, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Legend", legendPanel);

        legendItemPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1005, 50));

        upButton.setText("Up");

        downButton.setText("Down");

        addButton.setText("Add");

        editButton.setText("Edit...");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addContainerGap(516, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(editButton)
                    .addComponent(addButton)
                    .addComponent(downButton)
                    .addComponent(upButton))
                .addContainerGap())
        );

        legendItemPanel.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        legendItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Legend item", "Name"
            }
        ));
        legendItemTable.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(legendItemTable);
        legendItemTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (legendItemTable.getColumnModel().getColumnCount() > 0) {
            legendItemTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        jPanel4.add(scrollPane, java.awt.BorderLayout.CENTER);

        legendItemPanel.add(jPanel4, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Legend items", legendItemPanel);

        contentPanel.add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        add(contentPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void applyLegendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyLegendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applyLegendButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton addButton;
    protected javax.swing.JButton applyLegendButton;
    private javax.swing.JToolBar.Separator buttonSeparator;
    private javax.swing.JButton configureLegendStyleButton;
    private javax.swing.JPanel contentPanel;
    protected javax.swing.JButton downButton;
    protected javax.swing.JButton editButton;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel legendItemPanel;
    protected javax.swing.JTable legendItemTable;
    private javax.swing.JLabel legendNameLabel;
    protected javax.swing.JTextField legendNameTextField;
    private javax.swing.JPanel legendPanel;
    private javax.swing.JLabel legendStyleLabel;
    protected javax.swing.JButton newButton;
    protected javax.swing.JButton openButton;
    protected javax.swing.JButton removeButton;
    protected javax.swing.JButton saveButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel topPanel;
    protected javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables
}
