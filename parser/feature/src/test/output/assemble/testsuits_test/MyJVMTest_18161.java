import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_18161 {

    static Object eParam1 = 1;

    static int eParam2 = 621;

    static String eParam3 = "klTW8+ GL:";

    static long eParam4 = 7953347249104039072L;

    static int eParam5 = 540;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    FileDialog actionPerformed(ActionEvent e) {
        FileDialog fd = new FileDialog(new Frame());
        fd.setVisible(true);
        return fd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18161().actionPerformed(e);
    }
}
