import java.io.PrintStream;

public class MyJVMTest_3176 {

    static String outParam1 = "&N3f8Rp;6p";

    static PrintStream out = new PrintStream(outParam1);

    static boolean DEBUG_MODE = true;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("OLD redefclass003r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3176().checkIt(out, DEBUG_MODE));
    }
}
