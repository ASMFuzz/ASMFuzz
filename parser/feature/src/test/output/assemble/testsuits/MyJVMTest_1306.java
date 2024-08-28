public class MyJVMTest_1306 {

    static int[] a = { 4, 363315507, 6, 2094405080, 2, 4, 348310466, -2038539661, 8, 0 };

    static int[] b = { -997647480, 8, 1270266780, 0, 1308564963, 0, -1598768076, 9, 0, 0 };

    static int ALIGN_OFF = 8;

    int[] test_2ci_aln(int[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1306().test_2ci_aln(a, b);
    }
}
