public class MyJVMTest_8542 {

    static int[] a = { 0, 0, 0, 0, 64095697, 5, 0, 419875174, 0, 531784221 };

    static int[] b = { 4, 2, -667747431, 0, 0, 3, -1658312753, 0, 9, 1291687940 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalndst(int[] a, int[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8542().test_cp_unalndst(a, b);
    }
}
