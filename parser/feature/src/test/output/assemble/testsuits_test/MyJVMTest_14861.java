import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MyJVMTest_14861 {

    static JTree tree = null;

    void cancelCellEditing() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                tree.getCellEditor().cancelCellEditing();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14861().run();
    }
}
