public class MyJVMTest_17268 {

    static boolean Z = false;

    static byte B = 0;

    static short S = 0;

    static char C = '\'';

    static int I = 2;

    static long J = 9223372036854775807L;

    static float F = Float.MIN_VALUE;

    static double D = 0.10461141648348515;

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
        new MyJVMTest_17268().reset_values();
    }
}
