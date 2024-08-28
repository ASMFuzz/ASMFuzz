public class MyJVMTest_11933 {

    static long[] a = { 9223372036854775807L, -7459795922659370001L, 9223372036854775807L, -2239732319894166706L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, 0, 0 };

    static Long ibc = new Long(1);

    long sumc2(long[] a) {
        Long result1 = 1l;
        Long result2 = ibc;
        for (Long i : a) {
            result1 += i;
            result2 += i + ibc;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11933().sumc2(a));
    }
}
