public class MyJVMTest_7716 {

    static boolean Z = false;

    static byte B = 127;

    static short S = 32767;

    static char C = '0';

    static int I = 1;

    static long J = 0;

    static float F = Float.NaN;

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
        new MyJVMTest_7716().reset_values();
    }
}
