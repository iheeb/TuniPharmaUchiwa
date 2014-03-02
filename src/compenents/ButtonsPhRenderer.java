/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compenents;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author HoussemEddine
 */
public class ButtonsPhRenderer extends ButtonsPhPanel implements TableCellRenderer {
    public ButtonsPhRenderer() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(isSelected?table.getSelectionBackground():table.getBackground());
        return this;
    }
}
