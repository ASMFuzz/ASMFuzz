public class MyJVMTest_426 {

    static char[] a0 = { Character.MAX_VALUE, '0', '*', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '%', '0', Character.MIN_VALUE };

    static long[] p4 = { -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, -7782076432591096521L, -9223372036854775808L, 557878929840855396L, 0, 0, -9223372036854775808L };

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
        new MyJVMTest_426().test_unpack4_swap(a0, p4);
    }
}
