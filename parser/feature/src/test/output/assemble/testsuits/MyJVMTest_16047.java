import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_16047 {

    static String outParam1Param1 = "V;W'^l^B)P";

    static File outParam1 = new File(outParam1Param1);

    static String outParam2 = " gsP_eK<5 ";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("OLD redefclass010r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16047().checkIt(out, DEBUG_MODE));
    }
}
