import java.awt.*;
import javax.swing.*;

public class MyJVMTest_17704 {

    static Object value = 0;

    static boolean isSelected = false;

    static boolean hasFocus = false;

    static int row = 0;

    static int column = 0;

    static JCheckBox rendererCb = null;

    static JTable table = null;

    Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        rendererCb.setSelected(Boolean.TRUE.equals(value));
        return rendererCb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17704().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column));
    }
}
