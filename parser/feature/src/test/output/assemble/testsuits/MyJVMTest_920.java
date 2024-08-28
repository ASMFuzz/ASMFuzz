import java.io.PrintStream;

public class MyJVMTest_920 {

    static String outParam1 = "sw#sctE{EW";

    static PrintStream out = new PrintStream(outParam1);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("NEW redefclass008r: inside the checkIt()");
        return 73;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_920().checkIt(out, DEBUG_MODE));
    }
}
