public class MyJVMTest_11993 {

    static long[] a0 = { 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, -2464529885731400288L, -4608889456993548499L, 9223372036854775807L, 5408790897806132881L, 0, 9223372036854775807L };

    static long[] a1 = { 0, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, -984631390488869098L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

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
        new MyJVMTest_11993().test_unrl_addi(a0, a1);
    }
}
