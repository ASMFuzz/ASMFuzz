public class MyJVMTest_11007 {

    static short[] a = { 32767, -32768, 0, 32767, 28231, 0, -32768, 5325, -32768, 0 };

    static long[] b = { -2921766064300016274L, 0, 1215447773482857603L, 9223372036854775807L, 9223372036854775807L, -2070202170079236824L, -9223372036854775808L, 8991979652753753651L, -7206838494447620761L, -1416027201205615827L };

    short[] test_ci(short[] a, long[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11007().test_ci(a, b);
    }
}
