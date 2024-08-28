public class MyJVMTest_6023 {

    static long[] p4 = { -9223372036854775808L, -1302514239219331974L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L };

    static char[] a1 = { Character.MAX_VALUE, Character.MAX_VALUE, '0', ']', Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, 'Q', Character.MAX_VALUE };

    char[] test_pack4_swap(long[] p4, char[] a1) {
        if (p4.length * 4 > a1.length)
            return;
        for (int i = 0; i < p4.length; i += 1) {
            long l0 = (long) a1[i * 4 + 0];
            long l1 = (long) a1[i * 4 + 1];
            long l2 = (long) a1[i * 4 + 2];
            long l3 = (long) a1[i * 4 + 3];
            p4[i] = (l3 & 0xFFFFl) | ((l2 & 0xFFFFl) << 16) | ((l1 & 0xFFFFl) << 32) | ((l0 & 0xFFFFl) << 48);
        }
        return a1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6023().test_pack4_swap(p4, a1);
    }
}
