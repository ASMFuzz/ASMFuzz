public class MyJVMTest_7284 {

    static int[] a = { 0, 0, 0, -1548549174, 1119717769, 5, 1889800841, 5, 9, 3 };

    static int[] b = { 7, 9, 6, 2, 2, 2, 0, 1791928339, 1433834121, 3 };

    static int ALIGN_OFF = 8;

    int[] test_cp_alndst(int[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7284().test_cp_alndst(a, b);
    }
}
