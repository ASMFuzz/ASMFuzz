public class MyJVMTest_846 {

    static long[] a0 = { 0, 8469129698347505950L, -9223372036854775808L, -8430324593937617456L, 9223372036854775807L, 0, 9223372036854775807L, 0, 9223372036854775807L, -8628870656758511078L };

    static long[] a1 = { 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 6195079974288452222L, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, 9223372036854775807L };

    long[] test_unrl_lsai(long[] a0, long[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = (long) (a1[i + 0] << 0);
            a0[i + 1] = (long) (a1[i + 1] << 1);
            a0[i + 2] = (long) (a1[i + 2] << 2);
            a0[i + 3] = (long) (a1[i + 3] << 3);
        }
        for (; i < a0.length; i++) {
            a0[i] = (long) (a1[i] << (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_846().test_unrl_lsai(a0, a1);
    }
}
