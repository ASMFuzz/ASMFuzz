import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6986 {

    static Object eParam1 = 3;

    static int eParam2 = 69;

    static String eParam3 = "jSsbfJzpsJ";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    static JFrame fr = null;

    String actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Metal")) {
            s = "javax.swing.plaf.metal.MetalLookAndFeel";
        } else if (s.equals("Motif")) {
            s = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        } else {
            s = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        }
        try {
            UIManager.setLookAndFeel(s);
            SwingUtilities.updateComponentTreeUI(fr);
            fr.pack();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6986().actionPerformed(e);
    }
}
