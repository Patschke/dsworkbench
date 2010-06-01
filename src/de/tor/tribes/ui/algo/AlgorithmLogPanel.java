/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AlgorithmLogPanel.java
 *
 * Created on 29.01.2010, 11:00:59
 */
package de.tor.tribes.ui.algo;

import java.awt.Color;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JViewport;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Jejkal
 */
public class AlgorithmLogPanel extends javax.swing.JPanel {

    private SimpleDateFormat dateFormat = null;
    private boolean aborted = false;

    /** Creates new form AlgorithmLogPanel */
    public AlgorithmLogPanel() {
        initComponents();
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();

        // Create a style object and then set the style attributes
        Style defaultStyle = doc.addStyle("Default", null);
        StyleConstants.setItalic(defaultStyle, true);
        StyleConstants.setFontFamily(defaultStyle, "SansSerif");
        Style infoStyle = doc.addStyle("Info", null);
        StyleConstants.setItalic(infoStyle, true);
        StyleConstants.setFontFamily(infoStyle, "SansSerif");
        StyleConstants.setForeground(infoStyle, Color.LIGHT_GRAY);
        Style errorStyle = doc.addStyle("Error", null);
        StyleConstants.setFontFamily(errorStyle, "SansSerif");
        StyleConstants.setForeground(errorStyle, Color.RED);
        dateFormat = new SimpleDateFormat("HH:mm:ss");
    }

    public void setAbortable(boolean pValue) {
        jButton1.setEnabled(pValue);
    }

    public void clear() {
        jTextPane1.setText("");
        aborted = false;
    }

    public boolean isAborted() {
        return aborted;
    }

    public void addText(String pText) {
        try {
            StyledDocument doc = jTextPane1.getStyledDocument();
            doc.insertString(doc.getLength(), "(" + dateFormat.format(new Date(System.currentTimeMillis())) + ") " + pText + "\n", doc.getStyle("Default"));
            scroll();
        } catch (Throwable e) {
        }
    }

    public void addInfo(String pText) {
        try {
            StyledDocument doc = jTextPane1.getStyledDocument();
            doc.insertString(doc.getLength(), "(" + dateFormat.format(new Date(System.currentTimeMillis())) + ") " + pText + "\n", doc.getStyle("Info"));
            scroll();
        } catch (Throwable e) {
        }
    }

    public void addError(String pText) {
        try {
            StyledDocument doc = jTextPane1.getStyledDocument();
            doc.insertString(doc.getLength(), "(" + dateFormat.format(new Date(System.currentTimeMillis())) + ") " + pText + "\n", doc.getStyle("Error"));
            scroll();
        } catch (Throwable e) {
        }
    }

    private void scroll() {
        try {
            Point point = new Point(0, (int) (jTextPane1.getSize().getHeight()));
            JViewport vp = jScrollPane1.getViewport();
            if ((vp == null) || (point == null)) {
                return;
            }
            vp.setViewPosition(point);
        } catch (Throwable t) {
        }
    }

    public void updateStatus(int pCurrentStatus, int pMaxStatus) {
        jStatusProgress.setMaximum(pMaxStatus);
        jStatusProgress.setValue(pMaxStatus - pCurrentStatus);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jStatusProgress = new javax.swing.JProgressBar();

        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setText("Berechnung abbrechen");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireAbortEvent(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jStatusProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jStatusProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fireAbortEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireAbortEvent
        if (!jButton1.isEnabled() || aborted) {
            return;
        }
        addError("Berechnung vom Benutzer abgebrochen.");
        aborted = true;
    }//GEN-LAST:event_fireAbortEvent
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar jStatusProgress;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
