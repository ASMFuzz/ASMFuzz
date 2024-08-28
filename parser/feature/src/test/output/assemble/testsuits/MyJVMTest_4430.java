import java.lang.reflect.Field;

public class MyJVMTest_4430 {

    static String agentLib = "FastGetField";

    static boolean Z = false;

    static byte B = -128;

    static short S = -27630;

    static char C = Character.MAX_VALUE;

    static int I = 9;

    static long J = -9223372036854775808L;

    static float F = Float.MAX_VALUE;

    static double D = Double.MAX_VALUE;

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
        new MyJVMTest_4430().reset_values();
    }
}
