public class MyJVMTest_2243 {

    static long[] p4 = { 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, -5450676050484220510L, 0, 9223372036854775807L, 9223372036854775807L, 0, 0 };

    static char[] a1 = { 'm', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };

    char[] test_pack4(long[] p4, char[] a1) {
        if (p4.length * 4 > a1.length)
            return;
        for (int i = 0; i < p4.length; i += 1) {
            long l0 = (long) a1[i * 4 + 0];
            long l1 = (long) a1[i * 4 + 1];
            long l2 = (long) a1[i * 4 + 2];
            long l3 = (long) a1[i * 4 + 3];
            p4[i] = (l0 & 0xFFFFl) | ((l1 & 0xFFFFl) << 16) | ((l2 & 0xFFFFl) << 32) | ((l3 & 0xFFFFl) << 48);
        }
        return a1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2243().test_pack4(p4, a1);
    }
}
