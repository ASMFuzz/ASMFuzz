import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_16070 {

    static boolean DEBUG_MODE = true;

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static boolean outParam2 = true;

    static PrintStream out = new PrintStream(outParam1, outParam2);

    int checkIt(boolean DEBUG_MODE, PrintStream out) {
        if (DEBUG_MODE)
            out.println("OLD redefclass001r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16070().checkIt(DEBUG_MODE, out));
    }
}
