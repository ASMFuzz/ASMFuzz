public class MyJVMTest_2801 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, 7833834679295052753L, 9223372036854775807L, 0, 1097904707629468931L, -9223372036854775808L };

    static long[] b = { 0, 5189977367742046920L, 0, -2056825756453595029L, 9223372036854775807L, 0, -9223372036854775808L, 0, 0, -2500611359853561688L };

    long[] test_cp_oppos(long[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2801().test_cp_oppos(a, b);
    }
}
