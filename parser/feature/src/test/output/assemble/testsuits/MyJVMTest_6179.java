public class MyJVMTest_6179 {

    static char[] a0 = { Character.MAX_VALUE, '0', 's', '0', Character.MIN_VALUE, '0', '0', '6', Character.MAX_VALUE, Character.MIN_VALUE };

    static long[] p4 = { 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 912065994738543752L, 9223372036854775807L, 8364383491120834776L, 9223372036854775807L };

    char[] test_unpack4(char[] a0, long[] p4) {
        if (p4.length * 4 > a0.length)
            return;
        for (int i = 0; i < p4.length; i += 1) {
            long l = p4[i];
            a0[i * 4 + 0] = (char) (l & 0xFFFFl);
            a0[i * 4 + 1] = (char) (l >> 16);
            a0[i * 4 + 2] = (char) (l >> 32);
            a0[i * 4 + 3] = (char) (l >> 48);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6179().test_unpack4(a0, p4);
    }
}
