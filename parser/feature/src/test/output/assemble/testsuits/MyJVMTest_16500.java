import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16500 {

    static Object eParam1 = 7;

    static int eParam2 = 607;

    static String eParam3 = "@z$HmK/+]\\";

    static long eParam4 = 0;

    static int eParam5 = 108;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

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
        new MyJVMTest_16500().actionPerformed(e);
    }
}
