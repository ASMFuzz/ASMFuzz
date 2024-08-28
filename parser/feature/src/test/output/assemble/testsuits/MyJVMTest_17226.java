import java.io.*;

public class MyJVMTest_17226 {

    void checkPoint() throws IOException {
        throw new NumberFormatException("redefined");
    }

    static boolean testFailed = false;

    static PrintStream sout = null;

    void run() {
        try {
            checkPoint();
            sout.println("# checkPoint() does not throw any exception");
            testFailed = true;
        } catch (NumberFormatException ex) {
        } catch (Exception ex) {
            sout.println("# checkPoint() throws unexpected exception:");
            sout.println("# " + ex);
            testFailed = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17226().run();
    }
}
