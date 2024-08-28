import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_10686 {

    static int outParam1Param1 = 334;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static boolean outParam2 = false;

    static String outParam3 = "AV)}q@'cI4";

    static PrintStream out = new PrintStream(outParam1, outParam2, outParam3);

    static boolean DEBUG_MODE = true;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("OLD redefclass004r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10686().checkIt(out, DEBUG_MODE));
    }
}
