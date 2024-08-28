import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_4328 {

    static Object eParam1 = 0;

    static int eParam2 = 44;

    static String eParam3 = "YT%6]w'G9P";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

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
        new MyJVMTest_4328().actionPerformed(e);
    }
}
