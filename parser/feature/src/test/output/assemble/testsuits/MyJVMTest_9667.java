import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.Vector;

public class MyJVMTest_9667 {

    static Vector tableParam1 = new Vector();

    static Vector tableParam2 = new Vector();

    static JTable table = new JTable(tableParam1, tableParam2);

    static Object value = 2;

    static boolean isSelected = false;

    static int row = 8;

    static int col = 8;

    static JSlider slider = new JSlider(0, 10);

    Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int col) {
        int val = (Integer) value;
        slider.setValue(val);
        return slider;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9667().getTableCellEditorComponent(table, value, isSelected, row, col));
    }
}
