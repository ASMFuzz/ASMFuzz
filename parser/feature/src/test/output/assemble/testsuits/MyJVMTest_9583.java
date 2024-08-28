public class MyJVMTest_9583 {

    static char[] a0 = { Character.MAX_VALUE, Character.MIN_VALUE, '0', '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', 'h', Character.MIN_VALUE };

    static long[] p4 = { 9223372036854775807L, 9223372036854775807L, 0, 2623227902106665807L, -9223372036854775808L, 0, 9223372036854775807L, 695707231660491452L, -9223372036854775808L, 0 };

    char[] test_unpack4_swap(char[] a0, long[] p4) {
        if (p4.length * 4 > a0.length)
            return;
        for (int i = 0; i < p4.length; i += 1) {
            long l = p4[i];
            a0[i * 4 + 0] = (char) (l >> 48);
            a0[i * 4 + 1] = (char) (l >> 32);
            a0[i * 4 + 2] = (char) (l >> 16);
            a0[i * 4 + 3] = (char) (l & 0xFFFFl);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9583().test_unpack4_swap(a0, p4);
    }
}
