public class MyJVMTest_15743 {

    static long[] a = { 0, 5827776036374099385L, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, -8104920529473834888L, 0 };

    static long seed = -9223372036854775808L;

    long init(long[] a, long seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15743().init(a, seed);
    }
}
