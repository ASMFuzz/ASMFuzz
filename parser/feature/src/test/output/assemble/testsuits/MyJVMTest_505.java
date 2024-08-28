import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_505 {

    static TableModel tableParam1 = null;

    static TableColumnModel tableParam2 = null;

    static ListSelectionModel tableParam3 = null;

    static JTable table = new JTable(tableParam1, tableParam2, tableParam3);

    static Object value = 0;

    static boolean isSelected = true;

    static int row = -1552371094;

    static int col = 8;

    static JSlider slider = new JSlider(0, 10);

    Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int col) {
        int val = (Integer) value;
        slider.setValue(val);
        return slider;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_505().getTableCellEditorComponent(table, value, isSelected, row, col));
    }
}
