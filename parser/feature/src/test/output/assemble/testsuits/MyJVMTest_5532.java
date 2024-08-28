import java.io.PrintStream;

public class MyJVMTest_5532 {

    static boolean DEBUG_MODE = true;

    static String outParam1 = "x+S/Yj)jGB";

    static String outParam2 = "]CdbKn[4Ja";

    static PrintStream out = new PrintStream(outParam1, outParam2);

    int checkIt(boolean DEBUG_MODE, PrintStream out) {
        if (DEBUG_MODE)
            out.println("OLD JvmtiTestr: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5532().checkIt(DEBUG_MODE, out));
    }
}
