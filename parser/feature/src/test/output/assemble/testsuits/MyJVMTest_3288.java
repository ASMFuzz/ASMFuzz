public class MyJVMTest_3288 {

    static int[] a = { 2109678464, 0, 0, 7, 6, 1, 3, 5, 0, 1403746046 };

    static long[] b = { 0, -9223372036854775808L, 7020765118824798679L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 4656792904826176842L };

    int[] test_ci(int[] a, long[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3288().test_ci(a, b);
    }
}
