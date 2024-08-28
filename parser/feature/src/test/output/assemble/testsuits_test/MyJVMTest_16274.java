import java.lang.reflect.Field;

public class MyJVMTest_16274 {

    static String agentLib = "FastGetField";

    static boolean Z = true;

    static byte B = 28;

    static short S = 12822;

    static char C = '0';

    static int I = 2;

    static long J = 0;

    static float F = Float.POSITIVE_INFINITY;

    static double D = 0d;

    void change_values() {
        Z = true;
        B = 1;
        C = 1;
        S = 1;
        I = 1;
        J = 1l;
        F = 1.0f;
        D = 1.0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16274().change_values();
    }
}
