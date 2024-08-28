import java.io.PrintStream;

public class MyJVMTest_12023 {

    static String errParam1 = "%#d7|k;?A5";

    static PrintStream err = new PrintStream(errParam1);

    void printProcessErrorOutput(PrintStream printTo) {
        if (stderr != null && stderr.length() > 0) {
            printTo.println("========= Child VM System.err ========");
            printTo.print(stderr);
            printTo.println("======================================");
        }
    }

    static int exitValue = 7;

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
        new MyJVMTest_12023().verifyStdErr(err);
    }
}
