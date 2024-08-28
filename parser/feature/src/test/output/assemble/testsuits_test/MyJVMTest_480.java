import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_480 {

    static Object aeParam1 = 0;

    static int aeParam2 = 550;

    static String aeParam3 = "Kno4wmUKT6";

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3);

    static JDialog dialog = new JDialog((Window) null, "Test Dialog", Dialog.ModalityType.DOCUMENT_MODAL);

    ActionEvent actionPerformed(ActionEvent ae) {
        dialog.setVisible(true);
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_480().actionPerformed(ae);
    }
}
