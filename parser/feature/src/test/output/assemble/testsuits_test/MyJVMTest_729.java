public class MyJVMTest_729 {

    static int[] a = { 8, -133362957, 0, -1076252890, -1263062140, 1697393650, 1112767431, 1478450149, 0, 0 };

    static int[] b = { 85557677, 2, 0, 6, 420522712, -894915520, 3, 0, 2, -1166805921 };

    int[] test_cp_oppos(int[] a, int[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_729().test_cp_oppos(a, b);
    }
}
