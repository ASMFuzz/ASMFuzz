import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9640 {

    static Object aeParam1 = 5;

    static int aeParam2 = 910;

    static String aeParam3 = "a.?9j'1\\EP";

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3);

    static JDialog dialog = new JDialog((Window) null, "Test Dialog", Dialog.ModalityType.DOCUMENT_MODAL);

    ActionEvent actionPerformed(ActionEvent ae) {
        dialog.setVisible(true);
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9640().actionPerformed(ae);
    }
}
