public class MyJVMTest_8545 {

    static int[] a = { 8, 0, 0, 1750202048, 0, 5, 2, 0, 0, 0 };

    static int[] b = { 0, -1645770423, 3, 2, 9, 0, 7, 9, 0, 4 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_2ci_unaln(int[] a, int[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8545().test_2ci_unaln(a, b);
    }
}
