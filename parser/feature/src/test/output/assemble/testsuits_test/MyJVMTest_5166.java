import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_5166 {

    static TableModel tableParam1 = null;

    static JTable table = new JTable(tableParam1);

    static Object value = 0;

    static boolean isSelected = true;

    static boolean hasFocus = false;

    static int row = 48275302;

    static int col = 9;

    static JSlider slider = new JSlider(0, 10);

    Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        int val = (Integer) value;
        slider.setValue(val);
        return slider;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5166().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col));
    }
}
