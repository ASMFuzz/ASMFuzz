import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_10311 {

    static String printToParam1Param1 = "D3#$iP`60E";

    static String printToParam1Param2 = "Kq|KJ\\{v!!";

    static File printToParam1 = new File(printToParam1Param1, printToParam1Param2);

    static PrintStream printTo = new PrintStream(printToParam1);

    static int exitValue = 464157573;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    PrintStream printProcessStandartOutput(PrintStream printTo) {
        if (stdout != null && stdout.length() > 0) {
            printTo.println("========= Child VM System.out ========");
            printTo.print(stdout);
            printTo.println("======================================");
        }
        return printTo;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10311().printProcessStandartOutput(printTo);
    }
}
