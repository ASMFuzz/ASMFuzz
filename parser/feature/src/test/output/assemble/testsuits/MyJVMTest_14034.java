import java.io.PrintStream;

public class MyJVMTest_14034 {

    void thrower() throws NumberFormatException {
        throw new NumberFormatException("redefined");
    }

    static int LOOP_COUNT = 30000;

    static boolean testFailed = false;

    static PrintStream sout = null;

    void run() {
        try {
            for (int i = 0; ; i++) {
                if (i > LOOP_COUNT) {
                    thrower();
                    break;
                }
            }
            sout.println("# thrower() does not throw any exception");
            testFailed = true;
        } catch (NumberFormatException ex) {
        } catch (Exception ex) {
            sout.println("# thrower() throws unexpected exception:");
            sout.println("# " + ex);
            testFailed = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14034().run();
    }
}
