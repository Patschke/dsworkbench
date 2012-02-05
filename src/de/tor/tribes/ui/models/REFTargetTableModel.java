/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tor.tribes.ui.models;

import de.tor.tribes.types.ext.Village;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 *
 * @author Torridity
 */
public class REFTargetTableModel extends AbstractTableModel {

    private String[] columnNames = new String[]{
        "Dorf"
    };
    Class[] types = new Class[]{
        Village.class
    };
    private final List<Village> elements = new LinkedList<Village>();

    public void addRow(final Village pVillage) {
        Object result = CollectionUtils.find(elements, new Predicate() {

            @Override
            public boolean evaluate(Object o) {
                return ((Village) o).equals(pVillage);
            }
        });

        if (result == null) {
            elements.add(pVillage);
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        if (elements == null) {
            return 0;
        }
        return elements.size();
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void removeRow(int row) {
        elements.remove(row);
        fireTableDataChanged();
    }

    public Village getRow(int row) {
        return elements.get(row);
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (elements == null || elements.size() - 1 < row) {
            return null;
        }
        Village element = elements.get(row);
        switch (column) {
            default:
                return element;
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
}
