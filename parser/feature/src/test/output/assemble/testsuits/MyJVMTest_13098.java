import java.awt.*;
import javax.swing.*;

public class MyJVMTest_13098 {

    static Object value = 8;

    static boolean isSelected = true;

    static int row = 2;

    static int column = 5;

    static JCheckBox editorCb = null;

    static JTable table = null;

    static int editedRow = 0;

    Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.editedRow = row;
        editorCb.setSelected(Boolean.TRUE.equals(value));
        editorCb.setBackground(UIManager.getColor("Table.selectionBackground"));
        return editorCb;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13098().getTableCellEditorComponent(table, value, isSelected, row, column));
    }
}
