import java.io.PrintStream;
import java.net.URI;
import java.io.File;

public class MyJVMTest_15284 {

    static String outParam1Param1Param1 = "yk3%v&]g/%";

    static String outParam1Param1Param2 = "03IEl9<$iF";

    static String outParam1Param1Param3 = "jH+z[62/,L";

    static String outParam1Param1Param4 = "um^FYV>4)p";

    static URI outParam1Param1 = new URI(outParam1Param1Param1, outParam1Param1Param2, outParam1Param1Param3, outParam1Param1Param4);

    static File outParam1 = new File(outParam1Param1);

    static String outParam2 = "x%e`QR?UT.";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("redefclass006r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15284().checkIt(out, DEBUG_MODE));
    }
}
