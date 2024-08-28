import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_2733 {

    static String errParam1Param1 = "AAt?_M0YMu";

    static String errParam1Param2 = "FHe)f!^c22";

    static File errParam1 = new File(errParam1Param1, errParam1Param2);

    static PrintStream err = new PrintStream(errParam1);

    void printProcessErrorOutput(PrintStream printTo) {
        if (stderr != null && stderr.length() > 0) {
            printTo.println("========= Child VM System.err ========");
            printTo.print(stderr);
            printTo.println("======================================");
        }
    }

    static int exitValue = -748606628;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    PrintStream verifyStdErr(PrintStream err) {
        if (stderr != null && ((stderr.toString().toLowerCase().indexOf("error") != -1) || (stderr.toString().toLowerCase().indexOf("exception") != -1))) {
            printProcessErrorOutput(err);
            throw new RuntimeException("WARNING: Child process  error stream " + "is not empty!");
        }
        return err;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2733().verifyStdErr(err);
    }
}
