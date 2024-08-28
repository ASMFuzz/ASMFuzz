public class MyJVMTest_796 {

    static short[] a = { -19280, 32767, 1207, -32768, 32767, -32768, 32767, 32767, 32767, 32767 };

    static short[] b = { 0, 32767, -32768, 0, -32768, 32767, -20477, 26976, -3028, 13905 };

    static int[] c = { 0, -1594075823, 3, 4, 1389269726, -803404614, 7, 0, -637142565, 0 };

    static int[] d = { 7, 3, 9, -671931586, 0, 2104764891, 7, 0, 3, 5 };

    short[] test_cp_neg(short[] a, short[] b, int[] c, int[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_796().test_cp_neg(a, b, c, d);
    }
}
