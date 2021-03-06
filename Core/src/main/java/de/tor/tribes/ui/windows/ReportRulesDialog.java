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
package de.tor.tribes.ui.windows;

import de.tor.tribes.control.GenericManagerListener;
import de.tor.tribes.util.JOptionPaneHelper;
import de.tor.tribes.util.report.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;

/**
 *
 * @author Torridity
 */
public class ReportRulesDialog extends javax.swing.JDialog implements GenericManagerListener {

    @Override
    public void dataChangedEvent() {
        rebuildRuleList();
    }

    @Override
    public void dataChangedEvent(String pGroup) {
        dataChangedEvent();
    }

    /**
     * Creates new form ReportRulesDialog
     */
    public ReportRulesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ReportManager.getSingleton().addManagerListener(ReportRulesDialog.this);
        jMinDate.removeOk();
        jMaxDate.removeOk();
        fireRuleTypeChangedEvent(null);
        rebuildRuleList();
    }

    public void rebuildRuleList() {
        ReportManager.RuleEntry[] entries = ReportManager.getSingleton().getRuleEntries();
        DefaultListModel model = new DefaultListModel();

        for (ReportManager.RuleEntry entry : entries) {
            model.addElement(entry);
        }

        jRuleList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jReportColorPanel = new javax.swing.JPanel();
        jGreyBox = new javax.swing.JCheckBox();
        jBlueBox = new javax.swing.JCheckBox();
        jGreenBox = new javax.swing.JCheckBox();
        jYellowBox = new javax.swing.JCheckBox();
        jRedBox = new javax.swing.JCheckBox();
        jDatePanel = new javax.swing.JPanel();
        jMinDate = new de.tor.tribes.ui.components.DatePicker();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMaxDate = new de.tor.tribes.ui.components.DatePicker();
        jAttackerPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jAttackerTextArea = new javax.swing.JTextArea();
        jDefenderPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jDefenderTextArea = new javax.swing.JTextArea();
        jAttackerAllyPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jAttackerAllyTextArea = new javax.swing.JTextArea();
        jDefenderAllyPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jDefenderAllyTextArea = new javax.swing.JTextArea();
        jAgePanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jMaxAge = new javax.swing.JTextField();
        jNoSettingsPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jNoSettingsType = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRuleList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jRuleSelection = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jRuleSettingsPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTargetReportSet = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();

        jReportColorPanel.setMinimumSize(new java.awt.Dimension(352, 254));
        jReportColorPanel.setPreferredSize(new java.awt.Dimension(352, 254));
        jReportColorPanel.setLayout(new java.awt.GridBagLayout());

        jGreyBox.setText("Grau (Unbekannt)");
        jGreyBox.setMaximumSize(new java.awt.Dimension(157, 23));
        jGreyBox.setMinimumSize(new java.awt.Dimension(157, 23));
        jGreyBox.setPreferredSize(new java.awt.Dimension(157, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jReportColorPanel.add(jGreyBox, gridBagConstraints);

        jBlueBox.setText("Blau");
        jBlueBox.setMaximumSize(new java.awt.Dimension(157, 23));
        jBlueBox.setMinimumSize(new java.awt.Dimension(157, 23));
        jBlueBox.setPreferredSize(new java.awt.Dimension(157, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jReportColorPanel.add(jBlueBox, gridBagConstraints);

        jGreenBox.setText("Grün");
        jGreenBox.setMaximumSize(new java.awt.Dimension(157, 23));
        jGreenBox.setMinimumSize(new java.awt.Dimension(157, 23));
        jGreenBox.setPreferredSize(new java.awt.Dimension(157, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jReportColorPanel.add(jGreenBox, gridBagConstraints);

        jYellowBox.setText("Gelb ");
        jYellowBox.setMaximumSize(new java.awt.Dimension(157, 23));
        jYellowBox.setMinimumSize(new java.awt.Dimension(157, 23));
        jYellowBox.setPreferredSize(new java.awt.Dimension(157, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jReportColorPanel.add(jYellowBox, gridBagConstraints);

        jRedBox.setText("Rot");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jReportColorPanel.add(jRedBox, gridBagConstraints);

        jDatePanel.setMinimumSize(new java.awt.Dimension(352, 254));
        jDatePanel.setPreferredSize(new java.awt.Dimension(352, 254));
        jDatePanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        jDatePanel.add(jMinDate, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Von");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jDatePanel.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Bis");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jDatePanel.add(jLabel11, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        jDatePanel.add(jMaxDate, gridBagConstraints);

        jAttackerPanel.setMinimumSize(new java.awt.Dimension(352, 254));
        jAttackerPanel.setPreferredSize(new java.awt.Dimension(352, 254));
        jAttackerPanel.setLayout(new java.awt.GridBagLayout());

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mehrere Einträge per ; trennen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jAttackerPanel.add(jLabel3, gridBagConstraints);

        jAttackerTextArea.setColumns(20);
        jAttackerTextArea.setRows(5);
        jScrollPane2.setViewportView(jAttackerTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jAttackerPanel.add(jScrollPane2, gridBagConstraints);

        jDefenderPanel.setMinimumSize(new java.awt.Dimension(352, 254));
        jDefenderPanel.setPreferredSize(new java.awt.Dimension(352, 254));
        jDefenderPanel.setLayout(new java.awt.GridBagLayout());

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mehrere Einträge per ; trennen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jDefenderPanel.add(jLabel5, gridBagConstraints);

        jDefenderTextArea.setColumns(20);
        jDefenderTextArea.setRows(5);
        jScrollPane3.setViewportView(jDefenderTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jDefenderPanel.add(jScrollPane3, gridBagConstraints);

        jAttackerAllyPanel.setMinimumSize(new java.awt.Dimension(352, 254));
        jAttackerAllyPanel.setPreferredSize(new java.awt.Dimension(352, 254));
        jAttackerAllyPanel.setLayout(new java.awt.GridBagLayout());

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nur Stammestags zulässig, mehrere Einträge per ; trennen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jAttackerAllyPanel.add(jLabel7, gridBagConstraints);

        jAttackerAllyTextArea.setColumns(20);
        jAttackerAllyTextArea.setRows(5);
        jScrollPane4.setViewportView(jAttackerAllyTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jAttackerAllyPanel.add(jScrollPane4, gridBagConstraints);

        jDefenderAllyPanel.setMinimumSize(new java.awt.Dimension(352, 254));
        jDefenderAllyPanel.setPreferredSize(new java.awt.Dimension(352, 254));
        jDefenderAllyPanel.setLayout(new java.awt.GridBagLayout());

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nur Stammestags zulässig, mehrere Einträge per ; trennen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jDefenderAllyPanel.add(jLabel12, gridBagConstraints);

        jDefenderAllyTextArea.setColumns(20);
        jDefenderAllyTextArea.setRows(5);
        jScrollPane5.setViewportView(jDefenderAllyTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jDefenderAllyPanel.add(jScrollPane5, gridBagConstraints);

        jAgePanel.setMinimumSize(new java.awt.Dimension(352, 254));
        jAgePanel.setPreferredSize(new java.awt.Dimension(352, 254));
        jAgePanel.setLayout(new java.awt.GridBagLayout());

        jLabel13.setText("Max. Berichtalter [Tage]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jAgePanel.add(jLabel13, gridBagConstraints);

        jMaxAge.setText("365");
        jMaxAge.setMinimumSize(new java.awt.Dimension(100, 24));
        jMaxAge.setPreferredSize(new java.awt.Dimension(100, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jAgePanel.add(jMaxAge, gridBagConstraints);

        jNoSettingsPanel.setMinimumSize(new java.awt.Dimension(352, 254));
        jNoSettingsPanel.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("-Keine Einstellungen notwendig-");
        jNoSettingsPanel.add(jLabel14, new java.awt.GridBagConstraints());

        jNoSettingsType.setText("jLabel15");
        jNoSettingsType.setMaximumSize(new java.awt.Dimension(0, 0));
        jNoSettingsType.setMinimumSize(new java.awt.Dimension(0, 0));
        jNoSettingsType.setPreferredSize(new java.awt.Dimension(0, 0));
        jNoSettingsPanel.add(jNoSettingsType, new java.awt.GridBagConstraints());

        setTitle("Filterregeln für Berichte");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Vorhandene Regeln"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(23, 130));

        jRuleList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jRuleList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jButton1.setText("Löschen");
        jButton1.setToolTipText("Löscht die gewählte Regel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireDeleteRuleEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(jButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Neue Regel erstellen"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jRuleSelection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Berichte mit den Farben...", "Berichte die von ... bis ... gesendet wurden...", "Berichte die älter als ... Tage sind...", "Berichte mit Angreifer(n)...", "Berichte mit Verteidiger(n)...", "Berichte mit angreifenden Stämmen...", "Berichte mit verteidigenden Stämmen...", "Off-Berichte...", "Fake-Berichte...", "AG-Angriffe und Adelungen...", "Berichte mit Wallbeschädigung...", "Berichte mit Gebäudebeschädigung..." }));
        jRuleSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fireRuleTypeChangedEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jRuleSelection, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jSeparator1, gridBagConstraints);

        jRuleSettingsPanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel2.add(jRuleSettingsPanel, gridBagConstraints);

        jButton2.setText("Hinzufügen");
        jButton2.setToolTipText("Fügt die gewählte Regel hinzu");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireAddRuleEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jButton2, gridBagConstraints);

        jLabel8.setText("...verschieben in Berichtset");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel2.add(jLabel8, gridBagConstraints);

        jTargetReportSet.setText("default");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 2);
        jPanel2.add(jTargetReportSet, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jSeparator2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel2, gridBagConstraints);

        jButton4.setText("Schließen");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireCloseDialogEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jButton4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fireRuleTypeChangedEvent(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fireRuleTypeChangedEvent
        if (evt == null || evt.getStateChange() == ItemEvent.SELECTED) {
            int idx = jRuleSelection.getSelectedIndex();
            jRuleSettingsPanel.invalidate();
            jRuleSettingsPanel.removeAll();
            switch (idx) {
                case 0:
                    jRuleSettingsPanel.add(jReportColorPanel, BorderLayout.CENTER);
                    break;
                case 1:
                    jRuleSettingsPanel.add(jDatePanel, BorderLayout.CENTER);
                    break;
                case 2:
                    jRuleSettingsPanel.add(jAgePanel, BorderLayout.CENTER);
                    break;
                case 3:
                    jRuleSettingsPanel.add(jAttackerPanel, BorderLayout.CENTER);
                    break;
                case 4:
                    jRuleSettingsPanel.add(jDefenderPanel, BorderLayout.CENTER);
                    break;
                case 5:
                    jRuleSettingsPanel.add(jAttackerAllyPanel, BorderLayout.CENTER);
                    break;
                case 6:
                    jRuleSettingsPanel.add(jDefenderAllyPanel, BorderLayout.CENTER);
                    break;
                case 7:
                    jRuleSettingsPanel.add(jNoSettingsPanel, BorderLayout.CENTER);
                    jNoSettingsType.setText("OFF");
                    break;
                case 8:
                    jRuleSettingsPanel.add(jNoSettingsPanel, BorderLayout.CENTER);
                    jNoSettingsType.setText("FAKE");
                    break;
                case 9:
                    jRuleSettingsPanel.add(jNoSettingsPanel, BorderLayout.CENTER);
                    jNoSettingsType.setText("SNOB");
                    break;
                case 10:
                    jRuleSettingsPanel.add(jNoSettingsPanel, BorderLayout.CENTER);
                    jNoSettingsType.setText("WALL");
                    break;
                case 11:
                    jRuleSettingsPanel.add(jNoSettingsPanel, BorderLayout.CENTER);
                    jNoSettingsType.setText("BUILDING");
                    break;
            }
            jRuleSettingsPanel.revalidate();
            pack();
            repaint();
        }
    }//GEN-LAST:event_fireRuleTypeChangedEvent

    private void fireAddRuleEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireAddRuleEvent

        Component c = jRuleSettingsPanel.getComponent(0);
        String targetReportSet = jTargetReportSet.getText();
        if (targetReportSet == null || targetReportSet.length() == 0) {
            return;
        }
        try {
            if (c == jReportColorPanel) {
                ReportManager.getSingleton().addRule(createRule(ColorFilter.class), targetReportSet);
            } else if (c == jDatePanel) {
                ReportManager.getSingleton().addRule(createRule(DateFilter.class), targetReportSet);
            } else if (c == jAgePanel) {
                ReportManager.getSingleton().addRule(createRule(AgeFilter.class), targetReportSet);
            } else if (c == jAttackerPanel) {
                ReportManager.getSingleton().addRule(createRule(AttackerFilter.class), targetReportSet);
            } else if (c == jDefenderPanel) {
                ReportManager.getSingleton().addRule(createRule(DefenderFilter.class), targetReportSet);
            } else if (c == jAttackerAllyPanel) {
                ReportManager.getSingleton().addRule(createRule(AttackerAllyFilter.class), targetReportSet);
            } else if (c == jDefenderAllyPanel) {
                ReportManager.getSingleton().addRule(createRule(DefenderAllyFilter.class), targetReportSet);
            } else {
                //no settings panel
                if (jNoSettingsType.getText().equals("OFF")) {
                    ReportManager.getSingleton().addRule(createRule(OffFilter.class), targetReportSet);
                } else if (jNoSettingsType.getText().equals("FAKE")) {
                    ReportManager.getSingleton().addRule(createRule(FakeFilter.class), targetReportSet);
                } else if (jNoSettingsType.getText().equals("SNOB")) {
                    ReportManager.getSingleton().addRule(createRule(ConqueredFilter.class), targetReportSet);
                }else if (jNoSettingsType.getText().equals("WALL")) {
                    ReportManager.getSingleton().addRule(createRule(WallFilter.class), targetReportSet);
                }else if (jNoSettingsType.getText().equals("BUILDING")) {
                    ReportManager.getSingleton().addRule(createRule(CataFilter.class), targetReportSet);
                }
            }

            rebuildRuleList();
        } catch (ReportRuleConfigurationException rrce) {
            String message = "Regel konnte nicht erstellt werden.\nBitte prüfe die Einstellungen.";
            if (rrce.getMessage() != null) {
                message += "\n\nFehler: " + rrce.getMessage();
            }
            JOptionPaneHelper.showWarningBox(this, message, "Warnung");
        }
    }//GEN-LAST:event_fireAddRuleEvent

    private void fireDeleteRuleEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireDeleteRuleEvent

        ReportManager.RuleEntry selection = (ReportManager.RuleEntry) jRuleList.getSelectedValue();
        if (selection == null) {
            return;
        }

        if (selection.getRule() instanceof FarmReportFilter) {
            JOptionPaneHelper.showWarningBox(this, "Diese Regel kann nicht gelöscht werden.", "Warnung");
            return;
        }

        if (JOptionPaneHelper.showQuestionConfirmBox(this, "Regel '" + selection.getRule().getStringRepresentation() + "' wirklich löschen?", "Regel löschen", "Nein", "Ja") == JOptionPane.YES_OPTION) {
            ReportManager.getSingleton().removeRule(selection.getRule());
            rebuildRuleList();
        }
    }//GEN-LAST:event_fireDeleteRuleEvent

    private void fireCloseDialogEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireCloseDialogEvent
        setVisible(false);
    }//GEN-LAST:event_fireCloseDialogEvent

    public ReportRuleInterface createRule(Class pRuleClass) throws ReportRuleConfigurationException {
        ReportRuleInterface result = null;
        Object configuration = null;
        if (ColorFilter.class.equals(pRuleClass)) {
            result = new ColorFilter();
            int value = 0;
            value += (jGreyBox.isSelected()) ? ColorFilter.GREY : 0;
            value += (jBlueBox.isSelected()) ? ColorFilter.BLUE : 0;
            value += (jGreenBox.isSelected()) ? ColorFilter.GREEN : 0;
            value += (jYellowBox.isSelected()) ? ColorFilter.YELLOW : 0;
            value += (jRedBox.isSelected()) ? ColorFilter.RED : 0;
            configuration = value;
        } else if (DateFilter.class.equals(pRuleClass)) {
            result = new DateFilter();
            configuration = new Long[]{jMinDate.getDate().getTime(), jMaxDate.getDate().getTime()};
        } else if (AgeFilter.class.equals(pRuleClass)) {
            result = new AgeFilter();
            long val;
            try {
                val = Long.parseLong(jMaxAge.getText());
            } catch (Exception e) {
                val = 365;
            }
            configuration = val;
        } else if (AttackerFilter.class.equals(pRuleClass)) {
            result = new AttackerFilter();
            configuration = jAttackerTextArea.getText();
        } else if (DefenderFilter.class.equals(pRuleClass)) {
            result = new DefenderFilter();
            configuration = jDefenderTextArea.getText();
        } else if (AttackerAllyFilter.class.equals(pRuleClass)) {
            result = new AttackerAllyFilter();
            configuration = jAttackerAllyTextArea.getText();
        } else if (DefenderAllyFilter.class.equals(pRuleClass)) {
            result = new DefenderAllyFilter();
            configuration = jDefenderAllyTextArea.getText();
        } else if (OffFilter.class.equals(pRuleClass)) {
            result = new OffFilter();
        } else if (FakeFilter.class.equals(pRuleClass)) {
            result = new FakeFilter();
        } else if (ConqueredFilter.class.equals(pRuleClass)) {
            result = new ConqueredFilter();
        }else if (WallFilter.class.equals(pRuleClass)) {
            result = new WallFilter();
        }else if (CataFilter.class.equals(pRuleClass)) {
            result = new CataFilter();
        }

        result.setup(configuration);
        return result;
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
            java.util.logging.Logger.getLogger(ReportRulesDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Logger.getRootLogger().addAppender(new ConsoleAppender(new org.apache.log4j.PatternLayout("%d - %-5p - %-20c (%C [%L]) - %m%n")));


        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ReportRulesDialog dialog = new ReportRulesDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jAgePanel;
    private javax.swing.JPanel jAttackerAllyPanel;
    private javax.swing.JTextArea jAttackerAllyTextArea;
    private javax.swing.JPanel jAttackerPanel;
    private javax.swing.JTextArea jAttackerTextArea;
    private javax.swing.JCheckBox jBlueBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jDatePanel;
    private javax.swing.JPanel jDefenderAllyPanel;
    private javax.swing.JTextArea jDefenderAllyTextArea;
    private javax.swing.JPanel jDefenderPanel;
    private javax.swing.JTextArea jDefenderTextArea;
    private javax.swing.JCheckBox jGreenBox;
    private javax.swing.JCheckBox jGreyBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jMaxAge;
    private de.tor.tribes.ui.components.DatePicker jMaxDate;
    private de.tor.tribes.ui.components.DatePicker jMinDate;
    private javax.swing.JPanel jNoSettingsPanel;
    private javax.swing.JLabel jNoSettingsType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox jRedBox;
    private javax.swing.JPanel jReportColorPanel;
    private javax.swing.JList jRuleList;
    private javax.swing.JComboBox jRuleSelection;
    private javax.swing.JPanel jRuleSettingsPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTargetReportSet;
    private javax.swing.JCheckBox jYellowBox;
    // End of variables declaration//GEN-END:variables
}
