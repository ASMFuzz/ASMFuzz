import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_17851 {

    static JButton btnIM = null;

    static boolean inputMethodsEnabled = true;

    void setBtnText() {
        String s = inputMethodsEnabled ? "Disable" : "Enable";
        btnIM.setText(s + " Input Methods");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17851().setBtnText();
    }
}
