import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_7223 {

    static TableModel tableParam1 = null;

    static TableColumnModel tableParam2 = null;

    static ListSelectionModel tableParam3 = null;

    static JTable table = new JTable(tableParam1, tableParam2, tableParam3);

    static Object value = 0;

    static boolean isSelected = true;

    static boolean hasFocus = false;

    static int row = -643905801;

    static int col = 294095431;

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        int val = (Integer) value;
        slider.setValue(val);
        return slider;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7223().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col));
    }
}
