import java.io.InvalidClassException;

public class MyJVMTest_13578 {

    static String eParam1 = "$_5u17IPPy";

    static String eParam2Param1 = "+BEgRVE<f7";

    static String eParam2Param2Param1Param1 = "m$h6w%NA7C";

    static String eParam2Param2Param1Param2Param1 = "R]EQrZ'W'8";

    static String eParam2Param2Param1Param2Param2Param1Param1 = "].#:#-x\\}Q";

    static String eParam2Param2Param1Param2Param2Param1Param2Param1 = "i[M=A~ZDCE";

    static Throwable eParam2Param2Param1Param2Param2Param1Param2 = new Throwable(eParam2Param2Param1Param2Param2Param1Param2Param1);

    static Throwable eParam2Param2Param1Param2Param2Param1 = new Throwable(eParam2Param2Param1Param2Param2Param1Param1, eParam2Param2Param1Param2Param2Param1Param2);

    static Throwable eParam2Param2Param1Param2Param2 = new Throwable(eParam2Param2Param1Param2Param2Param1);

    static boolean eParam2Param2Param1Param2Param3 = true;

    static boolean eParam2Param2Param1Param2Param4 = true;

    static Throwable eParam2Param2Param1Param2 = new Throwable(eParam2Param2Param1Param2Param1, eParam2Param2Param1Param2Param2, eParam2Param2Param1Param2Param3, eParam2Param2Param1Param2Param4);

    static Throwable eParam2Param2Param1 = new Throwable(eParam2Param2Param1Param1, eParam2Param2Param1Param2);

    static Throwable eParam2Param2 = new Throwable(eParam2Param2Param1);

    static boolean eParam2Param3 = false;

    static boolean eParam2Param4 = true;

    static Throwable eParam2 = new Throwable(eParam2Param1, eParam2Param2, eParam2Param3, eParam2Param4);

    static boolean eParam3 = true;

    static boolean eParam4 = false;

    static Exception e = new Exception(eParam1, eParam2, eParam3, eParam4);

    Throwable isInvalidClassEx(Exception e) {
        Throwable cause = e;
        while (cause != null) {
            if (cause instanceof InvalidClassException) {
                System.out.println("---NewRMIClientFilterTest-InvalidClassException expected: " + cause);
                return;
            }
            cause = cause.getCause();
        }
        e.printStackTrace();
        throw new RuntimeException("Did not get expected InvalidClassException!");
        return cause;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13578().isInvalidClassEx(e);
    }
}
