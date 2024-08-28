import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_12992 {

    static OutputStream printToParam1 = new ByteArrayOutputStream();

    static boolean printToParam2 = false;

    static String printToParam3 = "r,yh_zSW%\"";

    static PrintStream printTo = new PrintStream(printToParam1, printToParam2, printToParam3);

    static int exitValue = 5;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    PrintStream printProcessErrorOutput(PrintStream printTo) {
        if (stderr != null && stderr.length() > 0) {
            printTo.println("========= Child VM System.err ========");
            printTo.print(stderr);
            printTo.println("======================================");
        }
        return printTo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12992().printProcessErrorOutput(printTo);
    }
}
