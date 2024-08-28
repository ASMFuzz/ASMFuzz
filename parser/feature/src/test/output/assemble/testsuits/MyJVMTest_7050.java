import javax.swing.*;

public class MyJVMTest_7050 {

    static String msg = "7s-;<|9wP@";

    static boolean passed = false;

    static UIDefaults defaults = null;

    String getUIError(String msg) {
        System.err.println("[II]  BrokenUIDefaults.getUIError() called, test passes");
        passed = true;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7050().getUIError(msg);
    }
}
