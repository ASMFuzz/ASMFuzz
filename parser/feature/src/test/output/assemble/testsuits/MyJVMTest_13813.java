import java.lang.reflect.Field;

public class MyJVMTest_13813 {

    static String agentLib = "FastGetField";

    static boolean Z = false;

    static byte B = -128;

    static short S = 0;

    static char C = '0';

    static int I = 2008318390;

    static long J = 9223372036854775807L;

    static float F = Float.POSITIVE_INFINITY;

    static double D = Double.MIN_VALUE;

    void reset_values() {
        Z = false;
        B = 0;
        C = 0;
        S = 0;
        I = 0;
        J = 0l;
        F = 0.0f;
        D = 0.0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13813().reset_values();
    }
}
