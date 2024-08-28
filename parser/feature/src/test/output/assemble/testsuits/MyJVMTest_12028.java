import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12028 {

    static Object aeParam1 = 8;

    static int aeParam2 = 401;

    static String aeParam3 = "LrVgt,\"M$T";

    static long aeParam4 = -9223372036854775808L;

    static int aeParam5 = 797;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    FileDialog actionPerformed(ActionEvent ae) {
        FileDialog dialog = new FileDialog((Frame) null, "Sample", FileDialog.LOAD);
        dialog.setVisible(true);
        return dialog;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12028().actionPerformed(ae);
    }
}
