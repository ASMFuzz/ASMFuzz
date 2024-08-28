import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_1116 {

    static String printToParam1Param1Param1Param1 = "@fFFu%:q\"9";

    static String printToParam1Param1Param1Param2 = ";g||v0e=W(";

    static File printToParam1Param1Param1 = new File(printToParam1Param1Param1Param1, printToParam1Param1Param1Param2);

    static String printToParam1Param1Param2 = "*92Jf2(i`H";

    static File printToParam1Param1 = new File(printToParam1Param1Param1, printToParam1Param1Param2);

    static String printToParam1Param2 = "hx`$9y!]<z";

    static File printToParam1 = new File(printToParam1Param1, printToParam1Param2);

    static String printToParam2 = "2M:GF}}*3~";

    static PrintStream printTo = new PrintStream(printToParam1, printToParam2);

    static int exitValue = 2047801746;

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
        new MyJVMTest_1116().printProcessStandartOutput(printTo);
    }
}
