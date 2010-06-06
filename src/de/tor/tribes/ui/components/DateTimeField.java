/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DateTimeField.java
 *
 * Created on Mar 3, 2010, 10:23:38 PM
 */
package de.tor.tribes.ui.components;

import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Torridity
 */
public class DateTimeField extends javax.swing.JPanel {

    private DatePicker dp;
    private TimePicker tp;
    private JDialog dlg;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss 'Uhr'");
    private boolean timeEnabled = true;

    /** Creates new form DateTimeField */
    public DateTimeField() {
        initComponents();
        jDateField.setText(dateFormat.format(Calendar.getInstance().getTime()));
        jTimeField.setText(timeFormat.format(Calendar.getInstance().getTime()));
        jChangeTime.setEnabled(timeEnabled);
        jTimeField.setEnabled(timeEnabled);
    }

    final class Listener extends ComponentAdapter {

        public void componentHidden(ComponentEvent componentevent) {
            if (componentevent.getSource() == dp) {
                Date date = ((DatePicker) componentevent.getSource()).getDate();
                if (null != date) {
                    jDateField.setText(dateFormat.format(date));
                }
            } else if (componentevent.getSource() == tp) {
                Date date = ((TimePicker) componentevent.getSource()).getTime();
                if (null != date) {
                    jTimeField.setText(timeFormat.format(date));
                }
            }
            dlg.dispose();
        }

        Listener() {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateField = new javax.swing.JTextField();
        jTimeField = new javax.swing.JTextField();
        jChangeDate = new javax.swing.JButton();
        jChangeTime = new javax.swing.JButton();

        jDateField.setMinimumSize(new java.awt.Dimension(10, 20));
        jDateField.setPreferredSize(new java.awt.Dimension(80, 20));

        jTimeField.setMinimumSize(new java.awt.Dimension(10, 20));
        jTimeField.setPreferredSize(new java.awt.Dimension(80, 20));

        jChangeDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ui/calendar_31.png"))); // NOI18N
        jChangeDate.setMaximumSize(new java.awt.Dimension(20, 20));
        jChangeDate.setMinimumSize(new java.awt.Dimension(20, 20));
        jChangeDate.setPreferredSize(new java.awt.Dimension(20, 20));
        jChangeDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireChangeDateTimeEvent(evt);
            }
        });

        jChangeTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ui/clock.png"))); // NOI18N
        jChangeTime.setMaximumSize(new java.awt.Dimension(20, 20));
        jChangeTime.setMinimumSize(new java.awt.Dimension(20, 20));
        jChangeTime.setPreferredSize(new java.awt.Dimension(20, 20));
        jChangeTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireChangeDateTimeEvent(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jTimeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jChangeDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jChangeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jChangeDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jChangeTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setEnabled(boolean pValue) {
        super.setEnabled(pValue);
        jDateField.setEnabled(pValue);
        jChangeDate.setEnabled(pValue);
        if (timeEnabled) {
            jChangeTime.setEnabled(pValue);
            jTimeField.setEnabled(pValue);
        } else {
            jChangeTime.setEnabled(false);
            jTimeField.setEnabled(false);
        }
    }

    public void setTimeEnabled(boolean pValue) {
        timeEnabled = pValue;
        jChangeTime.setEnabled(timeEnabled);
        jTimeField.setEnabled(timeEnabled);
        /* if (!timeEnabled) {
        jTimeField.setEnabled(false);
        } else {
        jTimeField.setEnabled(timeEnabled);
        }*/
    }

    public Date getSelectedDate() {
        try {
            Date date = dateFormat.parse(jDateField.getText());
            Date time = timeFormat.parse(jTimeField.getText());
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            Calendar result = Calendar.getInstance();
            result.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH));
            result.set(Calendar.MONTH, c.get(Calendar.MONTH));
            result.set(Calendar.YEAR, c.get(Calendar.YEAR));
            c.setTime(time);
            result.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY));
            result.set(Calendar.MINUTE, c.get(Calendar.MINUTE));
            result.set(Calendar.SECOND, c.get(Calendar.SECOND));

            return result.getTime();
        } catch (Exception e) {
            return Calendar.getInstance().getTime();
        }
    }

    public void setDate(Date pDate) {
        jDateField.setText(dateFormat.format(pDate));
        jTimeField.setText(timeFormat.format(pDate));
    }

    private void fireChangeDateTimeEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fireChangeDateTimeEvent
        if (!isEnabled()) {
            return;
        }
        if (evt.getSource() == jChangeDate) {
            try {
                dp = new DatePicker(dateFormat.parse(jDateField.getText()));
            } catch (Exception e) {
                dp = new DatePicker();
            }
            dp.addComponentListener(new Listener());
            Point point = jDateField.getLocationOnScreen();
            point.setLocation(point.getX(), (point.getY() - 1.0D) + jDateField.getSize().getHeight());
            dlg = new JDialog(new JFrame(), true);
            dlg.setLocation(point);
            //dlg.setResizable(false);
            dlg.setUndecorated(true);
            JPanel p = new JPanel();
            p.add(dp);
            dlg.getContentPane().add(p);

        } else {
            if (!timeEnabled) {
                return;
            }
            try {
                tp = new TimePicker(timeFormat.parse(jTimeField.getText()));
            } catch (Exception e) {
                tp = new TimePicker();
            }
            tp.addComponentListener(new Listener());

            Point point = jTimeField.getLocationOnScreen();
            point.setLocation(point.getX(), (point.getY() - 1.0D) + jTimeField.getSize().getHeight());
            dlg = new JDialog(new JFrame(), true);
            tp.setParent(dlg);
            dlg.setLocation(point);
            // dlg.setResizable(false);
            dlg.setUndecorated(true);
            JPanel p = new JPanel();
            p.add(tp);
            dlg.getContentPane().add(p);
        }

        dlg.pack();
        dlg.setVisible(true);
    }//GEN-LAST:event_fireChangeDateTimeEvent
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jChangeDate;
    private javax.swing.JButton jChangeTime;
    private javax.swing.JTextField jDateField;
    private javax.swing.JTextField jTimeField;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new DateTimeField());
        f.pack();
        f.setVisible(true);
    }
}
