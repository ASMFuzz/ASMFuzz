import javax.swing.*;
import java.awt.*;

public class MyJVMTest_10084 {

    static JCheckBox editorCb = null;

    Object getCellEditorValue() {
        return editorCb.isSelected();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10084().getCellEditorValue());
    }
}
