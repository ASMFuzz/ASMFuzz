public class MyJVMTest_13166 {

    static byte[] a = { 52, 47, 106, 29, -127, 91, -123, 3, -51, 3 };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -8831540369275555541L, 0, 1658777022481103546L, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L };

    byte[] test_ci(byte[] a, long[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13166().test_ci(a, b);
    }
}
