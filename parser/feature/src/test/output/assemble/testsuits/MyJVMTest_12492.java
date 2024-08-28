import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_12492 {

    static int outParam1Param1 = 998;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static boolean outParam2 = false;

    static String outParam3 = "P6L5# 6I_W";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("OLD redefclass003r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12492().checkIt(out, DEBUG_MODE));
    }
}
