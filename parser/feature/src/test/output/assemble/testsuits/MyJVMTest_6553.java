import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_6553 {

    static String outParam1Param1 = "T4y.|x'A[[";

    static String outParam1Param2 = "$CFm|f,56F";

    static File outParam1 = new File(outParam1Param1, outParam1Param2);

    static String outParam2 = "}xq,R^1'8c";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("OLD redefclass010r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6553().checkIt(out, DEBUG_MODE));
    }
}
