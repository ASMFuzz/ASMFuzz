public class MyJVMTest_29 {

    static long[] a = { 0, 0, -9223372036854775808L, 0, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 4205363723629829571L };

    static long[] b = { 9223372036854775807L, 4767605351359487288L, 2053512966140572063L, -777718002435641957L, -5226096778430638598L, -8574204274359333583L, 0, 7602706757131849540L, 0, -1660556776964050337L };

    static float[] c = { Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    static float[] d = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    long[] test_cp(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_29().test_cp(a, b, c, d);
    }
}
