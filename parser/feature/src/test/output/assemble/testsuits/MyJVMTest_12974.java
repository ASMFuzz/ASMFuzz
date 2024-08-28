import java.awt.Color;

public class MyJVMTest_12974 {

    static boolean pass = false;

    static boolean passed = false;

    static boolean printInvoked = false;

    static boolean done = false;

    boolean doClose(boolean pass) {
        if (printInvoked) {
            passed = pass;
            done = true;
        }
        return pass;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12974().doClose(pass);
    }
}
