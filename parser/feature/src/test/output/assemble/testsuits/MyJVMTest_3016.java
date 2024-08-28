public class MyJVMTest_3016 {

    static short[] a = { -32768, -5712, -32768, 0, 0, -32768, 0, 0, 32767, -32768 };

    static int[] b = { 9, 8, 0, 0, 4, 0, 2, -954619456, 8, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_ci_unaln(short[] a, int[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3016().test_ci_unaln(a, b);
    }
}
