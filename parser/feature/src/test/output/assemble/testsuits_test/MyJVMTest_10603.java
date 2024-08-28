import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_10603 {

    static int tableParam1 = 573;

    static int tableParam2 = 966;

    static JTable table = new JTable(tableParam1, tableParam2);

    static Object value = 0;

    static boolean isSelected = false;

    static int row = 9;

    static int col = 1261773900;

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int col) {
        int val = (Integer) value;
        slider.setValue(val);
        return slider;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10603().getTableCellEditorComponent(table, value, isSelected, row, col));
    }
}
