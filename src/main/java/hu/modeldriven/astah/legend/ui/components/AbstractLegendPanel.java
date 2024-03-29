package hu.modeldriven.astah.legend.ui.components;

/**
 * @author zsolt
 */
@SuppressWarnings({"squid:S1450"})
public class AbstractLegendPanel extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton addButton;
    protected javax.swing.JButton applyLegendButton;
    protected javax.swing.JButton configureStyleButton;
    protected javax.swing.JButton downButton;
    protected javax.swing.JButton editButton;
    protected javax.swing.JTable legendItemTable;
    protected javax.swing.JTextField legendNameTextField;
    protected javax.swing.JButton newButton;
    protected javax.swing.JButton openButton;
    protected javax.swing.JButton removeButton;
    protected javax.swing.JButton saveButton;
    protected javax.swing.JButton upButton;
    private javax.swing.JToolBar.Separator buttonSeparator;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel legendItemPanel;
    private javax.swing.JLabel legendNameLabel;
    private javax.swing.JPanel legendPanel;
    private javax.swing.JLabel legendStyleLabel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel topPanel;
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
        configureStyleButton = new javax.swing.JButton();
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

        topPanel.setLayout(new java.awt.BorderLayout());

        toolBar.setFloatable(true);
        toolBar.setRollover(true);

        newButton.setText("New");
        newButton.setFocusable(false);
        toolBar.add(newButton);

        openButton.setText("Open");
        openButton.setFocusable(false);
        toolBar.add(openButton);

        saveButton.setText("Save");
        saveButton.setFocusable(false);
        toolBar.add(saveButton);
        toolBar.add(buttonSeparator);

        applyLegendButton.setText("Apply on diagram");
        applyLegendButton.setFocusable(false);
        toolBar.add(applyLegendButton);

        topPanel.add(toolBar, java.awt.BorderLayout.CENTER);

        add(topPanel, java.awt.BorderLayout.NORTH);

        contentPanel.setLayout(new java.awt.BorderLayout());

        legendPanel.setBackground(new java.awt.Color(255, 255, 255));

        legendNameLabel.setText("Name:");

        legendStyleLabel.setText("Style:");

        configureStyleButton.setText("Configure...");

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
                                                .addComponent(configureStyleButton)
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
                                        .addComponent(configureStyleButton)
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
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
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
    // End of variables declaration//GEN-END:variables
}
