public class MyJVMTest_1401 {

    static int[] a = { 6, 9, 3, 1, 0, 0, 0, 1514099591, 6, -665186381 };

    static long[] b = { -9223372036854775808L, 4285970394012915583L, -9223372036854775808L, 0, 0, -9223372036854775808L, 9223372036854775807L, 0, -258265166699761949L, 3818129515145997401L };

    static int c = 0;

    static long d = 0;

    int[] test_vi(int[] a, long[] b, int c, long d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1401().test_vi(a, b, c, d);
    }
}
