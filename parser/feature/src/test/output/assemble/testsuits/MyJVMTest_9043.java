public class MyJVMTest_9043 {

    static long[] a = { -9223372036854775808L, 0, 0, 0, -9223372036854775808L, 6552982711328548812L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static long seed = -9223372036854775808L;

    long init(long[] a, long seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9043().init(a, seed);
    }
}
