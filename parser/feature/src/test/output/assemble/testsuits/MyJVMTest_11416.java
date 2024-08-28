import java.io.PrintStream;

public class MyJVMTest_11416 {

    static String outParam1 = "\\9.pcWo[CA";

    static PrintStream out = new PrintStream(outParam1);

    static boolean DEBUG_MODE = false;

    static int intFld = 3;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("redefclass005r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11416().checkIt(out, DEBUG_MODE));
    }
}
