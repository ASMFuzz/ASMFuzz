public class MyJVMTest_11219 {

    static byte[] a = { -95, -17, 76, 115, 42, 37, 20, -52, 22, 82 };

    static long[] b = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, 0, -2009675257217771427L, -9223372036854775808L, -9223372036854775808L, 0, 0 };

    static byte c = 116;

    static long d = -1577223352816697633L;

    byte[] test_vi(byte[] a, long[] b, byte c, long d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11219().test_vi(a, b, c, d);
    }
}
