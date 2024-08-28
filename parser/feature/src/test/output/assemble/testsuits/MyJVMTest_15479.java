public class MyJVMTest_15479 {

    static int[] a = { 2, 3, 1266413893, 3, 2, 4, 126183113, 0, 0, -1710286660 };

    static int[] b = { 3, 0, 2, -1598256744, 2110059868, 659091057, 0, 0, 0, -1232025186 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_cp_unalnsrc(int[] a, int[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15479().test_cp_unalnsrc(a, b);
    }
}
