public class MyJVMTest_12322 {

    static short[] a = { -32768, -32768, -32768, 26053, 0, 32767, -32768, 1486, 28228, 1165 };

    static int[] b = { 2, 7, 0, 4, 5, 8, 7, 0, 6, 0 };

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
        new MyJVMTest_12322().test_ci_unaln(a, b);
    }
}
