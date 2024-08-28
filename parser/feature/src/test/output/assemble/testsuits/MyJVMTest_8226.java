public class MyJVMTest_8226 {

    static int[] a0 = { 6, -1088782422, 0, 7, 1306017372, 7, 6, 5, 0, -170326275 };

    static long[] p2 = { 0, 9223372036854775807L, 8962842739009346054L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L };

    int[] test_unpack2(int[] a0, long[] p2) {
        if (p2.length * 2 > a0.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            long l = p2[i];
            a0[i * 2 + 0] = (int) (l & 0xFFFFFFFFl);
            a0[i * 2 + 1] = (int) (l >> 32);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8226().test_unpack2(a0, p2);
    }
}
