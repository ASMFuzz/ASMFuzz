public class MyJVMTest_7740 {

    static short[] a = { 0, -32768, 0, 0, -28846, 32767, -32768, -18705, 32767, 32767 };

    static int[] b = { 8, 4, -337057935, 2, 0, 1, 6, -2121112138, 1, 5 };

    static short c = -30066;

    static int d = -495486877;

    short[] test_vi_neg(short[] a, int[] b, short c, int d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7740().test_vi_neg(a, b, c, d);
    }
}
