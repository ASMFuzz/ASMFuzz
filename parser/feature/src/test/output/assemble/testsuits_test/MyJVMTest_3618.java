import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_3618 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static PrintStream out = new PrintStream(outParam1);

    static int errorLevel = 4;

    static int i = 7;

    static float f = Float.MIN_VALUE;

    static double d = Double.MIN_VALUE;

    static int errorStatus = 0;

    int errorAlert(PrintStream out, int errorLevel) {
        out.println("Test: failure #" + errorLevel);
        errorStatus = 2;
        return errorLevel;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3618().errorAlert(out, errorLevel);
    }
}
