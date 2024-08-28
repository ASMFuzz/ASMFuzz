public class MyJVMTest_16979 {

    static boolean Z = true;

    static byte B = 127;

    static short S = 8314;

    static char C = Character.MIN_VALUE;

    static int I = 0;

    static long J = 0;

    static float F = 0.16086078f;

    static double D = Double.NaN;

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
        new MyJVMTest_16979().change_values();
    }
}
