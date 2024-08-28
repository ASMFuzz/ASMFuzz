import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_14965 {

    static boolean DEBUG_MODE = false;

    static int outParam1Param1 = 152;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static boolean outParam2 = false;

    static String outParam3 = "UXP2I[E+gf";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

    int checkIt(boolean DEBUG_MODE, PrintStream out) {
        if (DEBUG_MODE)
            out.println("OLD JvmtiTestr: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14965().checkIt(DEBUG_MODE, out));
    }
}
