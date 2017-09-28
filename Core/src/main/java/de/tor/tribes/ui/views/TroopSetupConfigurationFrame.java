/* 
 * Copyright 2015 Torridity.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.tor.tribes.ui.views;

import de.tor.tribes.control.GenericManagerListener;
import de.tor.tribes.io.DataHolder;
import de.tor.tribes.io.TroopAmountElement;
import de.tor.tribes.types.StandardAttack;
import de.tor.tribes.ui.ImageManager;
import de.tor.tribes.ui.editors.NoteIconCellEditor;
import de.tor.tribes.ui.editors.StandardAttackElementEditor;
import de.tor.tribes.ui.models.AttackTypeTableModel;
import de.tor.tribes.ui.renderer.NoteIconCellRenderer;
import de.tor.tribes.ui.renderer.NoteIconListCellRenderer;
import de.tor.tribes.ui.renderer.StandardAttackTypeCellRenderer;
import de.tor.tribes.ui.renderer.UnitTableHeaderRenderer;
import de.tor.tribes.util.Constants;
import de.tor.tribes.util.GlobalOptions;
import de.tor.tribes.util.JOptionPaneHelper;
import de.tor.tribes.util.ProfileManager;
import de.tor.tribes.util.attack.StandardAttackManager;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author Torridity
 */
public class TroopSetupConfigurationFrame extends javax.swing.JDialog implements GenericManagerListener {
    
    private static TroopSetupConfigurationFrame SINGLETON = null;
    
    public static synchronized TroopSetupConfigurationFrame getSingleton() {
        if (SINGLETON == null) {
            SINGLETON = new TroopSetupConfigurationFrame();
        }
        return SINGLETON;
    }

    /**
     * Creates new form TroopSetupConfigurationDialog
     */
    TroopSetupConfigurationFrame() {
        super();
        setModal(true);
        initComponents();
        jXCollapsiblePane1.setLayout(new BorderLayout());
        jXCollapsiblePane2.setLayout(new BorderLayout());
        jXCollapsiblePane1.add(jSettingsPanel, BorderLayout.CENTER);
        jXCollapsiblePane2.add(jHelpPanel, BorderLayout.CENTER);
        StandardAttackManager.getSingleton().addManagerListener(TroopSetupConfigurationFrame.this);
        
        KeyStroke delete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0, false);
        ActionListener deleteListener = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelection();
            }
        };
        
        jAttackTypeTable.registerKeyboardAction(deleteListener, "Delete", delete, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        capabilityInfoPanel1.addActionListener(deleteListener);
         if (!Constants.DEBUG) {
            GlobalOptions.getHelpBroker().enableHelpKey(getRootPane(), "pages.standardAttacks", GlobalOptions.getHelpBroker().getHelpSet());
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jSettingsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jAttackTypeName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jAttackTypeIcon = new javax.swing.JComboBox();
        jAddTypeButton = new javax.swing.JButton();
        jHelpPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAttackTypeTable = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jXCollapsiblePane1 = new org.jdesktop.swingx.JXCollapsiblePane();
        jLabel3 = new javax.swing.JLabel();
        jXCollapsiblePane2 = new org.jdesktop.swingx.JXCollapsiblePane();
        capabilityInfoPanel1 = new de.tor.tribes.ui.components.CapabilityInfoPanel();

        jSettingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Neuen Angriffstyp erstellen"));
        jSettingsPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSettingsPanel.add(jLabel1, gridBagConstraints);

        jAttackTypeName.setMinimumSize(new java.awt.Dimension(6, 25));
        jAttackTypeName.setPreferredSize(new java.awt.Dimension(100, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSettingsPanel.add(jAttackTypeName, gridBagConstraints);

        jLabel2.setText("Icon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSettingsPanel.add(jLabel2, gridBagConstraints);

        jAttackTypeIcon.setMinimumSize(new java.awt.Dimension(23, 25));
        jAttackTypeIcon.setPreferredSize(new java.awt.Dimension(28, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSettingsPanel.add(jAttackTypeIcon, gridBagConstraints);

        jAddTypeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ui/add.png"))); // NOI18N
        jAddTypeButton.setToolTipText("Neuen Angriffstyp hinzufügen");
        jAddTypeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fireAddRemoveAttackTypeEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSettingsPanel.add(jAddTypeButton, gridBagConstraints);

        jHelpPanel.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jHelpPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        jHelpPanel.setLayout(new java.awt.GridBagLayout());

        jTextPane1.setContentType("text/html");
        jTextPane1.setText("<html>Standardangriffe sind voreingestellte Angriffe mit einer festgelegten Truppenzahl, die an vielen Stellen in DS Workbench verwendet werden k&ouml;nnen. So dienen sie z.B. dazu, die Angriffe eines Angriffsplans im Versammlungsplatz zu \n&ouml;ffnen und, sofern das DS Workbench Userscript installiert ist, die Truppen direkt einzuf&uuml;gen. Voraussetzung ist neben dem installierten Userscript auch, dass man die Truppeninformationen aus dem Spielaccount nach DS Workbench importiert \nhat. Mehr dazu erf&auml;hrst du in der Programmhilfe, die du mit F1 &ouml;ffnest. F&uuml;r die Festlegung von Standardangriffen hast du verschiedene M&ouml;glichkeiten:\n<UL><LI><I>Ganze Zahlen</I>, um eine feste Anzahl einer Truppenart einzufügen (z.B: '100')\n<LI><I>Alle</I>, um alle Truppen von einem Typ einzufügen die in DS Workbench importiert sind (z.B: 'Alle'). Beachte, dass diese Anzahl nicht der Zahl im Spiel entsprechen muss, falls die importierten Truppeninformationen veraltet sind.\n<LI><I>Alle - X</I>, um alle Truppen abzüglich einer bestimmten Anzahl einzufügen (z.B: 'Alle - 100') \n<LI><I>X%</I>, um einen prozentualen Anteil aller Truppen einzufügen (z.B: '50%') \n</UL> </html>");
        jScrollPane2.setViewportView(jTextPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jHelpPanel.add(jScrollPane2, gridBagConstraints);

        setTitle("Standardangriffe festlegen");
        setMinimumSize(new java.awt.Dimension(400, 200));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 362));

        jAttackTypeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jAttackTypeTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButton1.setText("Einstellungen");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fireShowHideSettingsEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        getContentPane().add(jButton1, gridBagConstraints);

        jXCollapsiblePane1.setCollapsed(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jXCollapsiblePane1, gridBagConstraints);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Informationen anzeigen");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fireShowHideInfoEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jXCollapsiblePane2.setCollapsed(true);
        jXCollapsiblePane2.setDirection(org.jdesktop.swingx.JXCollapsiblePane.Direction.DOWN);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jXCollapsiblePane2, gridBagConstraints);

        capabilityInfoPanel1.setBbSupport(false);
        capabilityInfoPanel1.setCopyable(false);
        capabilityInfoPanel1.setPastable(false);
        capabilityInfoPanel1.setSearchable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        getContentPane().add(capabilityInfoPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setup() {
        jAttackTypeTable.setModel(new AttackTypeTableModel());
        jAttackTypeTable.setHighlighters(HighlighterFactory.createAlternateStriping(Constants.DS_ROW_A, Constants.DS_ROW_B));
        jAttackTypeTable.getTableHeader().setDefaultRenderer(new UnitTableHeaderRenderer());
        jAttackTypeTable.setDefaultRenderer(TroopAmountElement.class, new StandardAttackTypeCellRenderer());
        jAttackTypeTable.setDefaultEditor(TroopAmountElement.class, new StandardAttackElementEditor());
        jAttackTypeTable.setDefaultEditor(Integer.class, new NoteIconCellEditor(NoteIconCellEditor.ICON_TYPE.NOTE));
        jAttackTypeTable.setRowHeight(24);
        jAttackTypeTable.getColumnExt(0).setMinWidth(120);
        jAttackTypeTable.getColumnExt(0).setPreferredWidth(120);
        jAttackTypeTable.setDefaultRenderer(Integer.class, new NoteIconCellRenderer(NoteIconCellRenderer.ICON_TYPE.NOTE));
        
        jAttackTypeIcon.setRenderer(new NoteIconListCellRenderer(NoteIconCellEditor.ICON_TYPE.NOTE));
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = -1; i <= ImageManager.MAX_NOTE_SYMBOL; i++) {
            model.addElement(i);
        }
        jAttackTypeIcon.setModel(model);
    }
    
    public AttackTypeTableModel getModel() {
        return (AttackTypeTableModel) jAttackTypeTable.getModel();
    }
    
    private void fireShowHideSettingsEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireShowHideSettingsEvent
        jXCollapsiblePane1.setCollapsed(!jXCollapsiblePane1.isCollapsed());
    }//GEN-LAST:event_fireShowHideSettingsEvent
    
    private void fireAddRemoveAttackTypeEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireAddRemoveAttackTypeEvent
        if (evt.getSource() == jAddTypeButton) {
            if (!StandardAttackManager.getSingleton().addStandardAttack(jAttackTypeName.getText(), (Integer) jAttackTypeIcon.getSelectedItem())) {
                JOptionPaneHelper.showWarningBox(this, "Angriffstyp konnte nicht hinzugefügt werden.\n"
                        + "Entweder sind der Name oder das Symbol bereits vergeben, oder der Name oder das Symbol sind reserviert.", "Fehler");
            }
        }
    }//GEN-LAST:event_fireAddRemoveAttackTypeEvent
    
    private void fireShowHideInfoEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireShowHideInfoEvent
        jXCollapsiblePane2.setCollapsed(!jXCollapsiblePane2.isCollapsed());
    }//GEN-LAST:event_fireShowHideInfoEvent
    
    private void removeSelection() {
        int[] rows = jAttackTypeTable.getSelectedRows();
        if (rows.length > 0) {
            
            if (JOptionPaneHelper.showQuestionConfirmBox(this, "Die Löschung eines Angriffstyps führt dazu, "
                    + "dass diesem Angriffstyp keine Truppen mehr zugeordnet werden.\n"
                    + "Dies kann bei noch abzuschickenden Angriffen problematisch werden.\n"
                    + "Willst du wirklich fortfahren?", "Nein", "Ja", "Löschung bestätigen") != JOptionPane.YES_OPTION) {
                return;
            }
            
            int removed = 0;
            StandardAttackManager.getSingleton().invalidate();
            for (int row : rows) {
                StandardAttack elem = StandardAttackManager.getSingleton().getManagedElement(jAttackTypeTable.convertRowIndexToModel(row));
                if (StandardAttackManager.getSingleton().removeStandardAttack(elem)) {
                    removed++;
                }
            }
            StandardAttackManager.getSingleton().revalidate(true);
            int delta = rows.length - removed;
            JOptionPaneHelper.showInformationBox(this, removed + " Eintrag/Einträge wurden entfernt."
                    + ((delta > 0) ? ("\n" + delta + " Eintrag/Einträge können nicht gelöscht werden.") : ""), "Information");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(TroopSetupConfigurationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        
        Logger.getRootLogger().addAppender(new ConsoleAppender(new org.apache.log4j.PatternLayout("%d - %-5p - %-20c (%C [%L]) - %m%n")));
        GlobalOptions.setSelectedServer("de77");
        ProfileManager.getSingleton().loadProfiles();
        GlobalOptions.setSelectedProfile(ProfileManager.getSingleton().getProfiles("de77")[0]);
        DataHolder.getSingleton().loadData(false);
        GlobalOptions.loadUserData();
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                TroopSetupConfigurationFrame.getSingleton().setup();
                TroopSetupConfigurationFrame.getSingleton().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private de.tor.tribes.ui.components.CapabilityInfoPanel capabilityInfoPanel1;
    private javax.swing.JButton jAddTypeButton;
    private javax.swing.JComboBox jAttackTypeIcon;
    private javax.swing.JTextField jAttackTypeName;
    private org.jdesktop.swingx.JXTable jAttackTypeTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jHelpPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jSettingsPanel;
    private javax.swing.JTextPane jTextPane1;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dataChangedEvent() {
        getModel().fireTableDataChanged();
    }
    
    @Override
    public void dataChangedEvent(String pGroup) {
        dataChangedEvent();
    }
}
