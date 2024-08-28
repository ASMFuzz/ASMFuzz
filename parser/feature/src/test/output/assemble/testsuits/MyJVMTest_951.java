public class MyJVMTest_951 {

    static int[] a = { 4, 0, 0, 0, 0, 0, -1194570410, 0, -1369299038, 0 };

    static int[] b = { 0, 1, 1, -715443203, 6, 0, 4, 762865744, 2, 1565131336 };

    static int c = 9;

    static int d = -1264208516;

    static int ALIGN_OFF = 8;

    int[] test_2vi_aln(int[] a, int[] b, int c, int d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_951().test_2vi_aln(a, b, c, d);
    }
}
