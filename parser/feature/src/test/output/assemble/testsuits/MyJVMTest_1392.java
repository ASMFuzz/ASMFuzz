import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_1392 {

    static TableModel tableParam1 = null;

    static JTable table = new JTable(tableParam1);

    static Object value = 1;

    static boolean isSelected = false;

    static int row = 9;

    static int col = 9;

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int col) {
        int val = (Integer) value;
        slider.setValue(val);
        return slider;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1392().getTableCellEditorComponent(table, value, isSelected, row, col));
    }
}
