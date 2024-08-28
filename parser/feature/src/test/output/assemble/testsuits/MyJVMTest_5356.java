public class MyJVMTest_5356 {

    static long[] a = { 3273807711909671991L, -274285004330272258L, 0, -1877084211938522321L, -9223372036854775808L, -8315076834034373055L, 9223372036854775807L, 9223372036854775807L, -2460589915960224998L, 2504952916776284876L };

    long[] test_ci(long[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5356().test_ci(a);
    }
}
