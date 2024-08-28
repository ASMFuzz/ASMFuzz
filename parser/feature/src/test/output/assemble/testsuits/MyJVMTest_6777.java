import java.lang.reflect.Field;

public class MyJVMTest_6777 {

    static String agentLib = "FastGetField";

    static boolean Z = false;

    static byte B = 127;

    static short S = 973;

    static char C = '4';

    static int I = 7;

    static long J = -9223372036854775808L;

    static float F = Float.MIN_VALUE;

    static double D = Double.MIN_VALUE;

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
        new MyJVMTest_6777().change_values();
    }
}
