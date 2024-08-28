import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_16746 {

    static int tableParam1 = 213;

    static int tableParam2 = 710;

    static JTable table = new JTable(tableParam1, tableParam2);

    static Object value = 3;

    static boolean isSelected = false;

    static boolean hasFocus = false;

    static int row = 1;

    static int col = 1346550820;

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        int val = (Integer) value;
        slider.setValue(val);
        return slider;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16746().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col));
    }
}
