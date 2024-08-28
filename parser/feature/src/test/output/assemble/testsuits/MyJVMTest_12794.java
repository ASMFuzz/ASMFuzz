public class MyJVMTest_12794 {

    static int[] a = { 1172354413, 2037622512, 4, 4, 2140387690, 3, -2105648015, 0, 5, 0 };

    static int[] b = { 5, 7, 3, -2060152439, 0, 0, 0, 0, 3, 6 };

    static long[] c = { 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 7378276364253713742L, -3935725125999259301L, 6079848521845204369L, 6403726851807576738L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L };

    static long[] d = { -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, 0, 0, 0, -9223372036854775808L, 0 };

    int[] test_cp_oppos(int[] a, int[] b, long[] c, long[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12794().test_cp_oppos(a, b, c, d);
    }
}
