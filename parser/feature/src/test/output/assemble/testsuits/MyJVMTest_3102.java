public class MyJVMTest_3102 {

    static short[] a = { 32767, -32190, 0, 0, -32768, -10871, -9162, -14350, 0, -32768 };

    static int[] b = { 0, 1160540335, 6, 0, -1265042793, 0, 984848978, 8, 0, 2 };

    static int ALIGN_OFF = 8;

    short[] test_ci_aln(short[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3102().test_ci_aln(a, b);
    }
}
