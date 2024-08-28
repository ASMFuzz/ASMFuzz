import javax.swing.*;
import java.awt.*;

public class MyJVMTest_12243 {

    static JCheckBox editorCb = null;

    static JTable table = null;

    static int editedRow = 2;

    boolean stopCellEditing() {
        table.getModel().setValueAt(editorCb.isSelected(), editedRow, 0);
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12243().stopCellEditing());
    }
}
