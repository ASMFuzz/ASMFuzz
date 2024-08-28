public class MyJVMTest_2085 {

    static long[] a = { 0, 0, -5482989662536036708L, 9015248572191461681L, -9223372036854775808L, -9223372036854775808L, 0, 0, -9223372036854775808L, -9223372036854775808L };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, 4024812952973826035L, 9223372036854775807L, 0, 0, 9223372036854775807L, -6651919115918489314L, 9223372036854775807L, -9223372036854775808L };

    long[] test_cp(long[] a, long[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2085().test_cp(a, b);
    }
}
