public class MyJVMTest_2706 {

    static long[] a0 = { 9223372036854775807L, 4890085544289446603L, -9223372036854775808L, 0, 0, -9223372036854775808L, 0, 0, -9223372036854775808L, 9223372036854775807L };

    static long[] a1 = { 475197777147944952L, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, 5725367424353565624L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L };

    long[] test_unrl_addi(long[] a0, long[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = (long) (a1[i + 0] + 0);
            a0[i + 1] = (long) (a1[i + 1] + 1);
            a0[i + 2] = (long) (a1[i + 2] + 2);
            a0[i + 3] = (long) (a1[i + 3] + 3);
        }
        for (; i < a0.length; i++) {
            a0[i] = (long) (a1[i] + (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2706().test_unrl_addi(a0, a1);
    }
}
