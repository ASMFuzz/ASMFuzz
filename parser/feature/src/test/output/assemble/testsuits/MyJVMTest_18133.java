public class MyJVMTest_18133 {

    static int[] a = { 0, 4, -468087281, 3, 9, 4, 0, 1, 5, 1114347815 };

    static int[] b = { 0, 9, 0, 0, 5, 0, 3, 5, -1675979521, 3 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalndst(int[] a, int[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18133().test_cp_unalndst(a, b);
    }
}
