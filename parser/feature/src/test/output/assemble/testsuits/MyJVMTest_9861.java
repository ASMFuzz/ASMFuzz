import java.io.PrintStream;
import java.net.URI;
import java.io.File;

public class MyJVMTest_9861 {

    static String outParam1Param1Param1 = "Sg>g8rx+B_";

    static String outParam1Param1Param2 = "r0u#6G}deE";

    static String outParam1Param1Param3 = "6zL@eH\"R3\"";

    static URI outParam1Param1 = new URI(outParam1Param1Param1, outParam1Param1Param2, outParam1Param1Param3);

    static File outParam1 = new File(outParam1Param1);

    static String outParam2 = "l$*X2\"fM%5";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        int i = 234;
        if (DEBUG_MODE)
            out.println("OLD redefclass009r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9861().checkIt(out, DEBUG_MODE));
    }
}
