import java.awt.*;
import javax.swing.*;

public class MyJVMTest_8133 {

    static Object value = 2;

    static boolean isSelected = false;

    static boolean hasFocus = false;

    static int row = -431364181;

    static int column = 0;

    static JCheckBox rendererCb = null;

    static JTable table = null;

    Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        rendererCb.setSelected(Boolean.TRUE.equals(value));
        return rendererCb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8133().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column));
    }
}
