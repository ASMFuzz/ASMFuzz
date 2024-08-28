public class MyJVMTest_15478 {

    static long[] p4 = { 9223372036854775807L, 2837499470602812428L, 9223372036854775807L, -6497866189063803162L, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, -597491164349209947L };

    static char[] a1 = { '0', '^', Character.MAX_VALUE, Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, '\\', 'A', '0' };

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
        new MyJVMTest_15478().test_pack4_swap(p4, a1);
    }
}
