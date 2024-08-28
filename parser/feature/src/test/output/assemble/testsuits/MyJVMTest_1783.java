public class MyJVMTest_1783 {

    static short[] a = { 0, -12235, -31796, 0, 7083, 32767, 9946, 32767, 0, 32767 };

    static long[] b = { 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, -1625958046573676402L, 0, 953862003506667016L, 9206631037491795066L, 9223372036854775807L, 1339386757192438708L };

    short[] test_ci(short[] a, long[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1783().test_ci(a, b);
    }
}
