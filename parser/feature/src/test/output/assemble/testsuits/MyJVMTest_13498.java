public class MyJVMTest_13498 {

    static int[] a0 = { 0, 0, 5891605, -1221496661, -730383337, -1679267695, 3, 5, 0, -2092497961 };

    static int[] a1 = { 0, 7, 7, 0, 8, 0, -731476196, 3, 0, 1 };

    static int b = 0;

    int[] test_xorv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] ^ b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13498().test_xorv(a0, a1, b);
    }
}
