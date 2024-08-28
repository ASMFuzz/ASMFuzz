public class MyJVMTest_7444 {

    static boolean Z = true;

    static byte B = 70;

    static short S = -32512;

    static char C = 'E';

    static int I = 1582872771;

    static long J = 2625973953653438479L;

    static float F = 0.5663887f;

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
        new MyJVMTest_7444().change_values();
    }
}
