public class MyJVMTest_18136 {

    static int[] a = { -493278309, 7, 1, 2, 2, -1607427372, 0, 5, -1347187324, 0 };

    static int[] b = { 8, 0, 1000820050, 0, -617660252, 8, 0, 1254692331, 3, 7 };

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
        new MyJVMTest_18136().test_2ci_unaln(a, b);
    }
}
