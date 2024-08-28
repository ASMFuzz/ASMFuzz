import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_5838 {

    static String outParam1Param1 = "A)1K.7S[bC";

    static File outParam1 = new File(outParam1Param1);

    static PrintStream out = new PrintStream(outParam1);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("redefclass006r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5838().checkIt(out, DEBUG_MODE));
    }
}
