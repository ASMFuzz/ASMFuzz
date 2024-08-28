public class MyJVMTest_2351 {

    static int[] a0 = { 4, 218177892, 1586441644, 0, 2, 3, 8, 8, 8, -1322674000 };

    static long[] p2 = { 9223372036854775807L, -2389050815589201888L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -7177425989658128069L, -9223372036854775808L, -9223372036854775808L, -2340874967958322143L };

    int[] test_unpack2_swap(int[] a0, long[] p2) {
        if (p2.length * 2 > a0.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            long l = p2[i];
            a0[i * 2 + 0] = (int) (l >> 32);
            a0[i * 2 + 1] = (int) (l & 0xFFFFFFFFl);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2351().test_unpack2_swap(a0, p2);
    }
}
