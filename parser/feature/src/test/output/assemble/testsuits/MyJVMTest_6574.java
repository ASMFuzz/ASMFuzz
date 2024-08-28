import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_6574 {

    static boolean DEBUG_MODE = true;

    static int outParam1Param1 = 727;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static PrintStream out = new PrintStream(outParam1);

    int checkIt(boolean DEBUG_MODE, PrintStream out) {
        if (DEBUG_MODE)
            out.println("OLD redefclass001r: inside the checkIt()");
        return 19;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6574().checkIt(DEBUG_MODE, out));
    }
}
