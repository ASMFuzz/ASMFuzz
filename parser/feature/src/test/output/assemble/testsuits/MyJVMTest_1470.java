import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_1470 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static PrintStream out = new PrintStream(outParam1);

    static boolean DEBUG_MODE = false;

    int checkIt(PrintStream out, boolean DEBUG_MODE) {
        if (DEBUG_MODE)
            out.println("OLD redefclass004r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1470().checkIt(out, DEBUG_MODE));
    }
}
