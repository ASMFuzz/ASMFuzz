import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_13702 {

    static Object eParam1 = -174012593;

    static int eParam2 = 544;

    static String eParam3 = "pEw)DZjN<S";

    static int eParam4 = 227;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    void setBtnText() {
        String s = inputMethodsEnabled ? "Disable" : "Enable";
        btnIM.setText(s + " Input Methods");
    }

    static TextArea txtArea = null;

    static TextField txtField = null;

    static JButton btnIM = null;

    static boolean inputMethodsEnabled = true;

    ActionEvent actionPerformed(ActionEvent e) {
        inputMethodsEnabled = !inputMethodsEnabled;
        setBtnText();
        txtArea.enableInputMethods(inputMethodsEnabled);
        txtField.enableInputMethods(inputMethodsEnabled);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13702().actionPerformed(e);
    }
}
