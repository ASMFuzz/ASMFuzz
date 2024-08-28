import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13587 {

    static Object aeParam1 = 0;

    static int aeParam2 = 533;

    static String aeParam3 = "vWhrcS]<?9";

    static long aeParam4 = 9223372036854775807L;

    static int aeParam5 = 365;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    FileDialog actionPerformed(ActionEvent ae) {
        FileDialog dialog = new FileDialog(new Frame(), "dialog");
        dialog.setVisible(true);
        return dialog;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13587().actionPerformed(ae);
    }
}
