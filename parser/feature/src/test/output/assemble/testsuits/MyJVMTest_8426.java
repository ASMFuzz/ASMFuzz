import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_8426 {

    static OutputStream errParam1 = new ByteArrayOutputStream();

    static PrintStream err = new PrintStream(errParam1);

    static int exitValue = 9;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    PrintStream verifyProcessExitValue(PrintStream err) {
        if (exitValue != 0) {
            throw new RuntimeException("Child process returns not 0 value!" + "Returned value is " + exitValue);
        }
        return err;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8426().verifyProcessExitValue(err);
    }
}
