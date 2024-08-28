public class MyJVMTest_10330 {

    static int[] a = { -2013975328, -1889475817, 5, 0, -1573097299, 3, -1021575139, 2, 3, 5 };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 0, 164778968369364346L, 0, 0, 0 };

    int[] test_ci_oppos(int[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10330().test_ci_oppos(a, b);
    }
}
