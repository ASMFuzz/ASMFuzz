public class MyJVMTest_17294 {

    static short[] a = { 32767, 32767, 0, -5344, -32768, 25898, 0, -2736, -32768, -32768 };

    static int[] b = { 1820649888, 0, 3, 6, 0, 0, 2, 5, 0, 0 };

    static short c = -32768;

    static int d = -1972037996;

    short[] test_vi_neg(short[] a, int[] b, short c, int d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17294().test_vi_neg(a, b, c, d);
    }
}
