public class MyJVMTest_16809 {

    static int[] a = { 0, 1, 9, 0, 0, 7, 0, 0, 0, 0 };

    static int[] b = { 0, 0, -1978813507, 5, 2, 6, 524236463, 9, 1026515910, 1539028016 };

    static int ALIGN_OFF = 8;

    int[] test_cp_alndst(int[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16809().test_cp_alndst(a, b);
    }
}
