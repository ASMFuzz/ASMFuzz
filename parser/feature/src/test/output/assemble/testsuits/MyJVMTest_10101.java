import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_10101 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static PrintStream out = new PrintStream(outParam1);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("NEW redefclass008r: inside the checkIt()");
        return 73;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10101().checkIt(out, DEBUG_MODE));
    }
}
