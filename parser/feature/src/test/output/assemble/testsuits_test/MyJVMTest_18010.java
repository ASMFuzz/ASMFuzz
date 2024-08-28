import java.io.PrintStream;

public class MyJVMTest_18010 {

    static String errParam1 = "6bLc-ll,v6";

    static PrintStream err = new PrintStream(errParam1);

    static int exitValue = 6;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    PrintStream verifyProcessExitValue(PrintStream err) {
        if (exitValue != 0) {
            throw new RuntimeException("Child process returns not 0 value!" + "Returned value is " + exitValue);
        }
        return err;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18010().verifyProcessExitValue(err);
    }
}
