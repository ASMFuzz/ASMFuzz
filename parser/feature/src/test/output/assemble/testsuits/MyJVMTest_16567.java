import javax.swing.*;

public class MyJVMTest_16567 {

    static String msg = "LFF8EV#Pc2";

    static boolean passed = false;

    static UIDefaults defaults = null;

    String getUIError(String msg) {
        System.err.println("[II]  BrokenUIDefaults.getUIError() called, test passes");
        passed = true;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16567().getUIError(msg);
    }
}
