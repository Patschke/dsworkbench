/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VillageRenderPanel.java
 *
 * Created on Jun 5, 2010, 5:56:57 PM
 */
package de.tor.tribes.ui;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author Torridity
 */
public class VillageRenderPanel extends javax.swing.JPanel {

    /** Creates new form VillageRenderPanel */
    public VillageRenderPanel() {
        initComponents();
    }

    public void setContent(JLabel pContent) {
        jPanel1.add(pContent);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/center.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireClickEvent(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void click(MouseEvent e){
        fireClickEvent(e);
    }

    private void fireClickEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireClickEvent
        System.out.println("CLICK");
    }//GEN-LAST:event_fireClickEvent

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
