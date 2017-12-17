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
package de.tor.tribes.ui.wiz.ref;

import de.tor.tribes.control.ManageableType;
import de.tor.tribes.io.TroopAmountFixed;
import de.tor.tribes.ui.wiz.tap.*;
import de.tor.tribes.io.UnitHolder;
import de.tor.tribes.types.AbstractTroopMovement;
import de.tor.tribes.types.Attack;
import de.tor.tribes.types.StandardAttack;
import de.tor.tribes.types.ext.Village;
import de.tor.tribes.ui.components.VillageOverviewMapPanel;
import de.tor.tribes.ui.models.REFResultTableModel;
import de.tor.tribes.ui.renderer.*;
import de.tor.tribes.ui.util.ColorGradientHelper;
import de.tor.tribes.ui.windows.AttackTransferDialog;
import de.tor.tribes.ui.wiz.ref.types.REFResultElement;
import de.tor.tribes.ui.wiz.tap.types.TAPAttackSourceElement;
import de.tor.tribes.ui.wiz.tap.types.TAPAttackTargetElement;
import de.tor.tribes.util.Constants;
import de.tor.tribes.util.JOptionPaneHelper;
import de.tor.tribes.util.algo.types.TimeFrame;
import de.tor.tribes.util.attack.StandardAttackManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
import javax.swing.SwingUtilities;
import org.apache.log4j.Logger;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import org.netbeans.spi.wizard.Wizard;
import org.netbeans.spi.wizard.WizardPage;
import org.netbeans.spi.wizard.WizardPanelNavResult;

/**
 *
 * @author Torridity
 */
public class SupportRefillFinishPanel extends WizardPage {

  private static final String GENERAL_INFO = "Die Berechnung ist abgeschlossen und im besten Fall wurden für die angegebenen Einstellungen und Truppeninformationen "
          + "Unterstützungen gefunden. Du kannst die Ergebnisse nun in die Befehlsübersicht übertragen, von dort im Browser öffnen und abschicken. Beachte dabei, "
          + "dass es sich bei der Abschickzeit um die späteste Abschickzeit handelt. Da es hier um Unterstützungen geht ist es kein Problem, wenn du die Befehle "
          + "vorher abschickst, falls die Abschickzeit mitten in der Nacht liegt oder du die Unterstützungen schnell in den Zieldörfern haben möchtest.";
  private static SupportRefillFinishPanel singleton = null;
  private VillageOverviewMapPanel overviewPanel = null;
  
  private Logger logger = Logger.getLogger("SupportRefillFinishPanel");
  
  public static synchronized SupportRefillFinishPanel getSingleton() {
    if (singleton == null) {
      singleton = new SupportRefillFinishPanel();
    }
    return singleton;
  }

  public static String getDescription() {
    return "Fertig";
  }

  public static String getStep() {
    return "id-ref-finish";
  }

  /**
   * Creates new form AttackSourcePanel
   */
  SupportRefillFinishPanel() {
    initComponents();
    jXCollapsiblePane1.setLayout(new BorderLayout());
    jXCollapsiblePane1.add(jInfoScrollPane, BorderLayout.CENTER);
    jInfoTextPane.setText(GENERAL_INFO);
    jxResultsTable.setHighlighters(HighlighterFactory.createAlternateStriping(Constants.DS_ROW_A, Constants.DS_ROW_B));
    jxResultsTable.getTableHeader().setDefaultRenderer(new DefaultTableHeaderRenderer());
    jxResultsTable.setDefaultRenderer(UnitHolder.class, new UnitCellRenderer());
    jxResultsTable.setDefaultRenderer(Date.class, new DateCellRenderer());
    overviewPanel = new VillageOverviewMapPanel();
    jPanel5.add(overviewPanel, BorderLayout.CENTER);
    jXCollapsiblePane2.add(jSummaryPanel, BorderLayout.CENTER);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jInfoScrollPane = new javax.swing.JScrollPane();
        jInfoTextPane = new javax.swing.JTextPane();
        jSummaryPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSupportedTargets = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jOverallSupports = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jUsedSourceVillages = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPerfectTargets = new javax.swing.JLabel();
        jXCollapsiblePane1 = new org.jdesktop.swingx.JXCollapsiblePane();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jxResultsTable = new org.jdesktop.swingx.JXTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jXCollapsiblePane2 = new org.jdesktop.swingx.JXCollapsiblePane();

        jInfoScrollPane.setMinimumSize(new java.awt.Dimension(19, 180));
        jInfoScrollPane.setPreferredSize(new java.awt.Dimension(19, 180));

        jInfoTextPane.setEditable(false);
        jInfoTextPane.setContentType("text/html"); // NOI18N
        jInfoTextPane.setText("<html>Du befindest dich im <b>Angriffsmodus</b>. Hier kannst du die Herkunftsd&ouml;rfer ausw&auml;hlen, die f&uuml;r Angriffe verwendet werden d&uuml;rfen. Hierf&uuml;r hast die folgenden M&ouml;glichkeiten:\n<ul>\n<li>Einf&uuml;gen von Dorfkoordinaten aus der Zwischenablage per STRG+V</li>\n<li>Einf&uuml;gen der Herkunftsd&ouml;rfer aus der Gruppen&uuml;bersicht</li>\n<li>Einf&uuml;gen der Herkunftsd&ouml;rfer aus dem SOS-Analyzer</li>\n<li>Einf&uuml;gen der Herkunftsd&ouml;rfer aus Berichten</li>\n<li>Einf&uuml;gen aus der Auswahlübersicht</li>\n<li>Manuelle Eingabe</li>\n</ul>\n</html>\n");
        jInfoScrollPane.setViewportView(jInfoTextPane);

        jSummaryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Zusammenfassung"));
        jSummaryPanel.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Unterstützte Ziele");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSummaryPanel.add(jLabel2, gridBagConstraints);

        jSupportedTargets.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSummaryPanel.add(jSupportedTargets, gridBagConstraints);

        jLabel4.setText("Zugeteilte Unterstützungen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSummaryPanel.add(jLabel4, gridBagConstraints);

        jOverallSupports.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSummaryPanel.add(jOverallSupports, gridBagConstraints);

        jLabel6.setText("Verwendete Herkunftsdörfer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSummaryPanel.add(jLabel6, gridBagConstraints);

        jUsedSourceVillages.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSummaryPanel.add(jUsedSourceVillages, gridBagConstraints);

        jLabel3.setText("Voll belegte Ziele");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSummaryPanel.add(jLabel3, gridBagConstraints);

        jPerfectTargets.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jSummaryPanel.add(jPerfectTargets, gridBagConstraints);

        setLayout(new java.awt.GridBagLayout());

        jXCollapsiblePane1.setCollapsed(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jXCollapsiblePane1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informationen einblenden");
        jLabel1.setToolTipText("Blendet Informationen zu dieser Ansicht und zu den Datenquellen ein/aus");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireHideInfoEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jLabel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Angegriffene Ziele"));

        jxResultsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jxResultsTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Abschließende Aktionen"));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/48x48/full_sword_clipboard.png"))); // NOI18N
        jButton1.setToolTipText("Alle Unterstützungen in die Befehlsübersicht übertragen");
        jButton1.setMaximumSize(new java.awt.Dimension(70, 70));
        jButton1.setMinimumSize(new java.awt.Dimension(70, 70));
        jButton1.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireTransferAllToAttackPlanEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 20);
        jPanel3.add(jButton1, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/48x48/selection_sword_clipboard.png"))); // NOI18N
        jButton4.setToolTipText("Ausgewählte Unterstützungen in die Befehlsübersicht übertragen");
        jButton4.setMaximumSize(new java.awt.Dimension(70, 70));
        jButton4.setMinimumSize(new java.awt.Dimension(70, 70));
        jButton4.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireSelectedToAttackPlanEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 20);
        jPanel3.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel5.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanel4.add(jPanel5, gridBagConstraints);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search.png"))); // NOI18N
        jToggleButton1.setToolTipText("Informationskarte vergrößern");
        jToggleButton1.setMaximumSize(new java.awt.Dimension(100, 23));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(100, 23));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(100, 23));
        jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fireViewStateChangeEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jToggleButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jPanel4, gridBagConstraints);

        jToggleButton2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jToggleButton2.setText("Zusammenfassung anzeigen");
        jToggleButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fireShowHideSummaryEvent(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jToggleButton2, gridBagConstraints);

        jXCollapsiblePane2.setCollapsed(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(jXCollapsiblePane2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void fireHideInfoEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireHideInfoEvent
      if (jXCollapsiblePane1.isCollapsed()) {
        jXCollapsiblePane1.setCollapsed(false);
        jLabel1.setText("Informationen ausblenden");
      } else {
        jXCollapsiblePane1.setCollapsed(true);
        jLabel1.setText("Informationen einblenden");
      }
    }//GEN-LAST:event_fireHideInfoEvent

    private void fireViewStateChangeEvent(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fireViewStateChangeEvent
      if (jToggleButton1.isSelected()) {
        overviewPanel.setOptimalSize(2);
        jScrollPane1.setViewportView(overviewPanel);
        jPanel2.remove(overviewPanel);
      } else {
        jScrollPane1.setViewportView(jxResultsTable);
        jPanel5.add(overviewPanel, BorderLayout.CENTER);

        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            jPanel5.updateUI();
          }
        });
      }
    }//GEN-LAST:event_fireViewStateChangeEvent

    private void fireShowHideSummaryEvent(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fireShowHideSummaryEvent
      jXCollapsiblePane2.setCollapsed(!jToggleButton2.isSelected());
    }//GEN-LAST:event_fireShowHideSummaryEvent

    private void fireTransferAllToAttackPlanEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireTransferAllToAttackPlanEvent
      List<Attack> attacks = new LinkedList<>();
      TroopAmountFixed split = SupportRefillSettingsPanel.getSingleton().getSplit();
      StandardAttack standardAttackType = null;
      for (ManageableType t : StandardAttackManager.getSingleton().getAllElements()) {
        StandardAttack a = (StandardAttack) t;
        if (a.equals(split)) {
          standardAttackType = a;
          break;
        }
      }
      
      //TODO set real Troop Amount
      for (int row = 0; row < jxResultsTable.getRowCount(); row++) {
        int modelRow = jxResultsTable.convertRowIndexToModel(row);
        REFResultElement move = getModel().getRow(modelRow);
        Attack a = move.asAttack();
        if (standardAttackType != null) {
          a.setType(standardAttackType.getIcon());
        }
        attacks.add(a);
      }
      transferToAttackView(attacks);
    }//GEN-LAST:event_fireTransferAllToAttackPlanEvent

    private void fireSelectedToAttackPlanEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireSelectedToAttackPlanEvent
      int[] selection = jxResultsTable.getSelectedRows();
      List<Attack> attacks = new LinkedList<>();
      TroopAmountFixed split = SupportRefillSettingsPanel.getSingleton().getSplit();
      StandardAttack used = null;
      for (ManageableType t : StandardAttackManager.getSingleton().getAllElements()) {
        StandardAttack a = (StandardAttack) t;
        if (a.equals(split)) {
          used = a;
          break;
        }
      }
      
      //TODO set real Troop Amount
      for (int row : selection) {
        int modelRow = jxResultsTable.convertRowIndexToModel(row);
        REFResultElement move = getModel().getRow(modelRow);
        Attack a = move.asAttack();
        if (used != null) {
          a.setType(used.getIcon());
        }
        attacks.add(a);
      }
      transferToAttackView(attacks);
    }//GEN-LAST:event_fireSelectedToAttackPlanEvent

  private void transferToAttackView(List<Attack> pToTransfer) {
    if (pToTransfer.isEmpty()) {
      JOptionPaneHelper.showInformationBox(this, "Keine Unterstützungen gewählt", "Information");
      return;
    }
    new AttackTransferDialog(TacticsPlanerWizard.getFrame(), true).setupAndShow(pToTransfer.toArray(new Attack[pToTransfer.size()]));
  }

  private REFResultTableModel getModel() {
    return (REFResultTableModel) jxResultsTable.getModel();
  }

  public void update() {
    List<AbstractTroopMovement> results = SupportRefillCalculationPanel.getSingleton().getResults();
    TimeFrame timeFrame = SupportRefillCalculationPanel.getSingleton().getTimeFrame();
    if(logger.isDebugEnabled()) {
        StringBuilder log = new StringBuilder();
        for(AbstractTroopMovement movement: results) {
            log.append(System.lineSeparator());
            log.append(movement.getTarget().getCoordAsString()).append("/");
            log.append(movement.getOffCount());
        }
        
        logger.debug(log);
    }
    List<Long> used = new LinkedList<>();
    REFResultTableModel model = new REFResultTableModel();
    int perfectTargets = 0;
    int supportedTargets = 0;
    int maxSupports = 0;
    int assignedSupports = 0;
    List<Village> usedSources = new LinkedList<>();
    overviewPanel.reset();

    for (TAPAttackSourceElement elem : AttackSourceFilterPanel.getSingleton().getFilteredElements()) {
      overviewPanel.addVillage(new Point(elem.getVillage().getX(), elem.getVillage().getY()), Color.BLACK);
    }

    for (TAPAttackTargetElement elem : AttackTargetPanel.getSingleton().getAllElements()) {
      overviewPanel.addVillage(new Point(elem.getVillage().getX(), elem.getVillage().getY()), Color.BLACK);
    }

    for (AbstractTroopMovement result : results) {
      result.finalizeMovement(timeFrame, used);
      if (result.offComplete()) {
        perfectTargets++;
      }
      maxSupports += result.getMaxOffs();
      //int supportCount = result.getOffCount();
      //assignedSupports += supportCount;

      /*if (supportCount > 0) {
       supportedTargets++;
       }*/
      Attack[] attacks = result.getFinalizedAttacks();
      if (attacks.length > 0) {
        supportedTargets++;
      }
      for (Attack a : attacks) {
        if (!usedSources.contains(a.getSource())) {
          usedSources.add(a.getSource());
          overviewPanel.addVillage(new Point(a.getSource().getX(), a.getSource().getY()), Color.YELLOW);
        }
        model.addRow(a.getSource(), a.getTarget(), a.getUnit(), a.getArriveTime());
        assignedSupports++;
      }
      overviewPanel.addVillage(new Point(result.getTarget().getX(), result.getTarget().getY()),
              ColorGradientHelper.getGradientColor(100.0f * (float) result.getFinalizedAttacks().length / (float) result.getMaxOffs(), Color.RED, Color.BLACK));
    }

    jxResultsTable.setModel(model);
    jSupportedTargets.setText(Integer.toString(supportedTargets) + " von " + results.size());
    jPerfectTargets.setText(Integer.toString(perfectTargets));
    jOverallSupports.setText(Integer.toString(assignedSupports) + " von " + Integer.toString(maxSupports));
    jUsedSourceVillages.setText(Integer.toString(usedSources.size()) + " von " + SupportRefillSourcePanel.getSingleton().getAllElements().length);
    focusSubmit();
  }

  private void focusSubmit() {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        jButton1.requestFocusInWindow();
      }
    });
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jInfoScrollPane;
    private javax.swing.JTextPane jInfoTextPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jOverallSupports;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jPerfectTargets;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jSummaryPanel;
    private javax.swing.JLabel jSupportedTargets;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel jUsedSourceVillages;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane1;
    private org.jdesktop.swingx.JXCollapsiblePane jXCollapsiblePane2;
    private org.jdesktop.swingx.JXTable jxResultsTable;
    // End of variables declaration//GEN-END:variables

  @Override
  public WizardPanelNavResult allowNext(String string, Map map, Wizard wizard) {
    return WizardPanelNavResult.PROCEED;
  }

  @Override
  public WizardPanelNavResult allowBack(String string, Map map, Wizard wizard) {
    return WizardPanelNavResult.PROCEED;

  }

  @Override
  public WizardPanelNavResult allowFinish(String string, Map map, Wizard wizard) {
    return WizardPanelNavResult.PROCEED;
  }
}
