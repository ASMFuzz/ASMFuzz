public class MyJVMTest_10612 {

    static int[] a = { 0, 0, 2, 8, -1261045269, 3, 647307481, -676104949, 0, 0 };

    static long[] b = { 0, -4566723012928756999L, 0, 9221999765398847477L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L };

    static int c = 0;

    static long d = 9223372036854775807L;

    int[] test_vi(int[] a, long[] b, int c, long d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10612().test_vi(a, b, c, d);
    }
}
