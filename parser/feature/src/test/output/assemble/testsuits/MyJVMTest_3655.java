import java.io.PrintStream;

public class MyJVMTest_3655 {

    static String printToParam1 = "Qz3&mp[Y['";

    static String printToParam2 = "$ P$u;D]1*";

    static PrintStream printTo = new PrintStream(printToParam1, printToParam2);

    static int exitValue = 0;

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
        new MyJVMTest_3655().printProcessErrorOutput(printTo);
    }
}
