public class MyJVMTest_6267 {

    static long[] a = { 9223372036854775807L, 0, -262692485778046210L, 0, 0, 0, 2436355613426232983L, 9223372036854775807L, -9011673143317609886L, 0 };

    static long seed = 0;

    long init(long[] a, long seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6267().init(a, seed);
    }
}
