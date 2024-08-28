public class MyJVMTest_2987 {

    static long[] a0 = { -6463580738586446432L, -9223372036854775808L, 0, 3788403036620264897L, 9223372036854775807L, 0, 9223372036854775807L, 0, 8459412774280505610L, -7218030593819634597L };

    long[] test_init(long[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (long) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2987().test_init(a0);
    }
}
