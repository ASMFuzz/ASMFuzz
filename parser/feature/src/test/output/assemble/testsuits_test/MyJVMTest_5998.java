import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5998 {

    static JCheckBox checkbox = null;

    Object getCellEditorValue() {
        return checkbox.isSelected();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5998().getCellEditorValue());
    }
}
