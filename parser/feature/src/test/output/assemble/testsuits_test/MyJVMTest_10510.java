public class MyJVMTest_10510 {

    static int[] a = { 0, -1166034783, 112912341, 1409822275, 511446633, 1095279521, 4, 1, 9, 1265766197 };

    static int[] b = { 5, 0, -1434097262, 7, 0, -1930768596, 8, 6, 880126285, 2033698091 };

    static int ALIGN_OFF = 8;

    int[] test_2ci_aln(int[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10510().test_2ci_aln(a, b);
    }
}
