public class MyJVMTest_2536 {

    static short[] a = { 0, -32768, -10319, 0, 32767, 0, -32768, 32767, 32767, -29590 };

    static long[] b = { -7162233674549241923L, 0, 9223372036854775807L, 8240476700565993165L, 9223372036854775807L, -8779358248854295397L, -9223372036854775808L, 0, 0, 0 };

    short[] test_ci_oppos(short[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2536().test_ci_oppos(a, b);
    }
}
