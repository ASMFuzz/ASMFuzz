import java.io.PrintStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_12953 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static PrintStream out = new PrintStream(outParam1);

    static int errorLevel = 0;

    static int i = -37008377;

    static float f = Float.POSITIVE_INFINITY;

    static double d = Double.MAX_VALUE;

    static int errorStatus = 0;

    int errorAlert(PrintStream out, int errorLevel) {
        out.println("Test: failure #" + errorLevel);
        errorStatus = 2;
        return errorLevel;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12953().errorAlert(out, errorLevel);
    }
}
