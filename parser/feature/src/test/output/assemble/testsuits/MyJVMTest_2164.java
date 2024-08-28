import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_2164 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static boolean outParam2 = true;

    static PrintStream out = new PrintStream(outParam1, outParam2);

    static boolean DEBUG_MODE = true;

    static int intFld = 3;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("redefclass005r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2164().checkIt(out, DEBUG_MODE));
    }
}
