import java.awt.*;
import javax.swing.*;

public class MyJVMTest_3759 {

    static Object value = 0;

    static boolean isSelected = false;

    static int row = 7;

    static int column = 4;

    static JCheckBox editorCb = null;

    static JTable table = null;

    static int editedRow = 2;

    Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.editedRow = row;
        editorCb.setSelected(Boolean.TRUE.equals(value));
        editorCb.setBackground(UIManager.getColor("Table.selectionBackground"));
        return editorCb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3759().getTableCellEditorComponent(table, value, isSelected, row, column));
    }
}
