public class MyJVMTest_6024 {

    static int[] a = { 0, -175220661, 0, 4, 1372846083, 9, 9, 2, 0, 8 };

    static int[] b = { 0, 8, -900591466, 1, 3, -207803264, 0, 0, 0, 1 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalnsrc(int[] a, int[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6024().test_cp_unalnsrc(a, b);
    }
}
